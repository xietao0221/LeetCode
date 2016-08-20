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
        if(head == null || k == 0) return head;
        
        ListNode curr = head, tail = null, res = null;
        int count = 0;
        
        // find the list's size and its tail node
        while(curr != null) {
            count++;
            tail = curr;
            curr = curr.next;
        }
        
        k %= count;
        if(count == 1 || k == 0) return head;
        
        // find the head of second part
        curr = head;
        while(count-- > k) {
            if(count == k) {
                res = curr.next;
                curr.next = null;
            } else {
                curr = curr.next;
            }
        }
        tail.next = head;
        return res;
    }
}