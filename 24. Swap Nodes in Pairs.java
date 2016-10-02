/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// without helper function
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = prev.next;
        
        while(curr != null && curr.next != null) {
            ListNode target = curr.next, next = target.next;

            target.next = curr;
            prev.next = target;
            curr.next = next;

            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}

// similar to '25. Reverse Nodes in k-Group'
/*
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0), begin = dummy;
        dummy.next = head;
        int count = 0;
        
        while(head != null) {
            if(++count % 2 == 0) {
                begin = reverseList(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
    
    private ListNode reverseList(ListNode begin, ListNode end) {
        ListNode head = begin.next, target = head.next, res = head;
        while(target != end) {
            ListNode next = target.next;
            
            target.next = begin.next;
            begin.next = target;
            
            target = next;
            head.next = target;
        }
        return res;
    }
}
*/