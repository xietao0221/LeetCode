/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode firstHead = new ListNode(0), firstTail = firstHead,
                secondHead = new ListNode(0), secondTail = secondHead, target = head;
        while(target != null) {
            ListNode nextTarget = target.next;
            if(target.val < x) {
                firstTail.next = target;
                firstTail = firstTail.next;
            } else {
                secondTail.next = target;
                secondTail = secondTail.next;
            }
            target = nextTarget;
        }
        firstTail.next = secondHead.next;
        secondTail.next = null;
        return firstHead.next;
    }
}