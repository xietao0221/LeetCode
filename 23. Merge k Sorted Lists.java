/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new NodeComparator());
        for(ListNode node: lists) {
            if(node != null) queue.offer(node);
        }
        
        ListNode dummy = new ListNode(0), curr = dummy;
        while(!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            if(curr.next != null) queue.offer(curr.next);
        }
        return dummy.next;
    }
    
    class NodeComparator implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    }
}