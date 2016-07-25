/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // iterative approach
    /*
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    */
    
    // recursive approach
    public ListNode reverseList(ListNode head) {
        return reverseListHelper(head, null);
    }
    
    public ListNode reverseListHelper(ListNode curr, ListNode prev) {
        if(curr == null) return prev;
        ListNode next = curr.next;
        curr.next = prev;
        return reverseListHelper(next, curr);
    }
}