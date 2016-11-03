/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>(), stack2 = new Stack<>();
        pushIntoStack(l1, stack1);
        pushIntoStack(l2, stack2);
        
        ListNode curr = new ListNode(0);
        int carry = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop().val, b = stack2.isEmpty() ? 0 : stack2.pop().val;
            
            int sum = a + b + carry;
            curr.val = sum % 10;
            carry = sum / 10;
            
            ListNode prev = new ListNode(0);
            prev.next = curr;
            curr = prev;
        }
        return curr.next;
    }
    
    private void pushIntoStack(ListNode head, Stack<ListNode> stack) {
        while(head != null) {
            stack.push(head);
            head = head.next;
        }
    }
}