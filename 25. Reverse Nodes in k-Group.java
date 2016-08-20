/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
/**
 * Reverse a link list between begin and end exclusively
 * an example:
 * a linked list:
 * 0->1->2->3->4->5->6
 * |           |   
 * begin       end
 * after call begin = reverse(begin, end)
 * 
 * 0->3->2->1->4->5->6
 *          |  |
 *      begin end
 * @return the reversed list's 'begin' node, which is the precedence of node end
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) return head;
        ListNode dummy = new ListNode(0), begin = dummy;
        dummy.next = head;
        int count = 0;
        while(head != null) {
            if(++count % k == 0) {
                begin = reverseList(begin, head.next);
                head = begin.next;          // move head to the next round
            } else {
                head = head.next;           // move head one step forward
            }
        }
        return dummy.next;
    }
    
    // each round, cut down the curr
    public ListNode reverseList(ListNode begin, ListNode end) {
        ListNode head = begin.next, target = head.next, res = head;
        while(target != end) {
            // remember the next round's target
            ListNode next = target.next;
            
            // move target between 'begin' and 'head'
            target.next = begin.next;       // target -> head
            begin.next = target;            // begin -> target
            
            // resume target
            target = next;                  // move target to next round's target
            head.next = target;             // re-connect the head and next target
        }
        
        // return the end of reversed list, which is the begin of next round
        return res;
    }
}