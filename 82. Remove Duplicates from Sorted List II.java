/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0), prev = dummy, curr = head;
        dummy.next = head;
        
        while(curr != null) {
            // skip the nodes which is potential duplicated
            while(curr.next != null && curr.val == curr.next.val) curr = curr.next;
            
            if(prev.next == curr) prev = prev.next;     // if there is just one 'duplicate', skip
            else prev.next = curr.next;                 // otherwise, remove them all
            
            curr = curr.next;                           // move forward curr
        }
        return dummy.next;
    }
}