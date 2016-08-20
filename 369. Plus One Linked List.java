/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        if(head == null) return null;
        if(getCarry(head)) {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }
    
    // return true means get carry 1, otherwise get carry 0
    private boolean getCarry(ListNode node) {
        if(node == null) return true;
        
        if(getCarry(node.next)) {
            if(node.val <= 8) {
                node.val += 1;
                return false;
            } else {
                node.val = 0;
                return true;
            }
        }
        return false;
    }
}