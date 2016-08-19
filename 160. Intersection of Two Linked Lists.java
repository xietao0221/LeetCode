/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        // find the length of these two list
        ListNode curr = headA;
        int lenA = 0, lenB = 0, diff = 0;
        while(curr != null) {
            curr = curr.next;
            lenA++;
        }
        
        curr = headB;
        while(curr != null) {
            curr = curr.next;
            lenB++;
        }
        
        ListNode longer = lenA >= lenB ? headA : headB, shorter = lenA >= lenB ? headB : headA;
        
        // move diff steps on longer
        diff = Math.abs(lenA - lenB);
        while(diff-- > 0) longer = longer.next;
        
        // move as same speed to find the intersection
        while(longer != null && shorter != null) {
            if(longer == shorter) return longer;
            longer = longer.next;
            shorter = shorter.next;
        }
        return null;
    }
}