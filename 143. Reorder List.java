/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Reverse the second list in-place
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return;
        
        // find the middle point
        ListNode first = head, second = head;
        while(second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        ListNode firstTail = first;     // 1->2->(3)->4->5; 1->(2)->3->4

        // reverse the second part
        ListNode curr = firstTail.next, prev = null;
        firstTail.next = null;          // cut the list into two part
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            second = prev;              // second is the candidate head for the second list
        }
        
        // reorder interleaving
        first = head;
        while(second != null) {         // the second list is shorter, so use second as the marker of stop
            ListNode firstNext = first.next, secondNext = second.next;
            first.next = second;
            second.next = firstNext;
            
            // restore
            first = firstNext;
            second = secondNext;
        }
    }
}

// Use stack to reverse
/*
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        
        while(curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        
        int count = (stack.size() - 1) / 2;
        curr = head;
        while(count-- > 0) {
            ListNode next = curr.next;
            curr.next = stack.pop();
            curr.next.next = next;
            curr = next;
        }
        stack.pop().next = null;
    }
}
*/