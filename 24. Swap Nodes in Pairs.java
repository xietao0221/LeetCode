/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = head.next;
        // 1 -> 2 -> 3 -> 4
        // we should include more than one operation in one step, because the difference between 
        while(head != null && head.next != null) {
            // save next round's node, nextRound = 3
            ListNode nextRound = head.next.next;
            // 1 -> 2 -> 1
            head.next.next = head;
            // 2 -> 1 -> 4
            head.next = nextRound == null ? null : (nextRound.next == null ? nextRound : nextRound.next);
            // move to next round's node, head = 3
            head = nextRound;
        }
        return newHead;
    }
}