/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode slow = head, fast = head, pre = head;
        
        // slow is the head of second part, 
        // and the second part is one more than the first part if totatl number is odd
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;        // cut the list into two part
        return merge(sortList(head), sortList(slow));
    }
    
    // it is '21. Merge Two Sorted Lists'
    // because it is the part of merge sort, in this function, we just need to make one step
    // we do not need while loop and dummy node
    private ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}