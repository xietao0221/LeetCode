/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// https://discuss.leetcode.com/topic/8976/simple-java-solution-with-clear-explanation
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        for(int i=0; i<m-1; i++) prev = prev.next;
        
        ListNode start = prev.next, curr = start.next;
        for(int i=0; i<n-m; i++) {
            start.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = start.next;
        }
        return dummy.next;
    }
}