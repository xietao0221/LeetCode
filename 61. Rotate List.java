/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // get the length of linked list
        ListNode curr = head, slow = head, fast = head;
        int len = 0;
        while(curr != null) {
            len++;
            curr = curr.next;
        }
        if(head == null || k % len == 0) return head;
        
        // make a gap and iterate the list
        k %= len;
        while(k-- > 0) fast = fast.next;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // cut down and concatenate
        ListNode res = slow.next;
        slow.next = null;
        fast.next = head;
        
        return res;
    }
}