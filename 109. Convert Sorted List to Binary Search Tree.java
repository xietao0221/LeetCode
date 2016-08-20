/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode node;
    
    public TreeNode sortedListToBST(ListNode head) {
        node = head;
        ListNode curr = head;
        int size = 0;
        while(curr != null) {
            curr = curr.next;
            size++;
        }
        return sortedListToBSTHelper(0, size - 1);
    }
    
    public TreeNode sortedListToBSTHelper(int start, int end) {
        if(start > end) return null;
        int middle = start + (end - start) / 2;
        TreeNode left = sortedListToBSTHelper(start, middle - 1);
        
        TreeNode root = new TreeNode(node.val);
        node = node.next;
        root.left = left;
        
        TreeNode right = sortedListToBSTHelper(middle + 1, end);
        root.right = right;
        
        return root;
    }
}