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
       ListNode dummy = new ListNode(0), curr = dummy;
       int sum = 0, carry = 0;
       while(l1 != null || l2 != null || carry != 0) {
           sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
           carry = sum / 10;
           sum %= 10;
           curr.next = new ListNode(sum);
           
           curr = curr.next;
           l1 = l1 != null ? l1.next : l1;
           l2 = l2 != null ? l2.next : l2;
       }
       return dummy.next;
    }
}