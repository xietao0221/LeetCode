/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0), prev = dummy, curr = head;
        dummy.next = head;
        
        while(curr != null) {
            if(curr.val == val) prev.next = curr.next;      // make a jump
            else prev = prev.next;                          // move prev
            curr = curr.next;                               // move curr
        }
        return dummy.next;
    }
}