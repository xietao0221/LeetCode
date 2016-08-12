/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode curr = head, newHead = head, newTail = null, fast = head, right, left;
        
        // use fast-slow pointer to find the middle and reverse the left part
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            
            // reverse the left part
            newHead = curr.next;
            curr.next = newTail;
            newTail = curr;
            curr = newHead;
        }
        
        // deal with odd/even and setup the head of left/right part
        if(fast.next != null) {         // total is even
            // curr.next is the head of right part, and its next is to the right
            right = curr.next;
            // curr is the head of left part, but its next is to the right, we have to reverse the link
            curr.next = newTail;
            left = curr;
        } else {                        // total is odd
            // newHead is at the middle, and its next is to the right; its next is the head of right part
            right = newHead.next;
            // newTail is on the left of middle, and its next is to the left; it is the head of left part
            left = newTail;
        }

        // palindrome check
        while(right != null) {
            if(right.val != left.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
}