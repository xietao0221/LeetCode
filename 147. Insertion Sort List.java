/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode newHead = head, newTail = head, target = head.next;
        while(target != null) {
            ListNode nextTarget = target.next;
            
            if(target.val <= newHead.val) {
                // target is smaller than the head, insert it before the head
                target.next = newHead;
                newHead = target;
            } else if(target.val >= newTail.val) {
                // target is larger than the tail, insert in after the tail
                newTail.next = target;
                newTail = target;
            } else {
                // target should be in the middle of sorted list, find the right place
                ListNode curr = newHead;
                while(curr.next != null && curr.next.val <= target.val) curr = curr.next;
                ListNode next = curr.next;
                curr.next = target;
                target.next = next;
            }
            
            target = nextTarget;
        }
        newTail.next = null;
        return newHead;
    }
}