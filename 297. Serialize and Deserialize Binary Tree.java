/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return null;
        
        boolean keepgoing = true;
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        sb.append(root.val).append(",");
        
        while(!queue.isEmpty() && keepgoing) {
            keepgoing = false;
            int size = queue.size();
            while(size-- > 0) {
                TreeNode curr = queue.poll();
                
                if(curr.left != null) {
                    sb.append(curr.left.val).append(",");
                    queue.offer(curr.left);
                    if(curr.left.left != null || curr.left.right != null) keepgoing = true;
                } else {
                    sb.append("null,");
                }
                
                if(curr.right != null) {
                    sb.append(curr.right.val).append(",");
                    queue.offer(curr.right);
                    if(curr.right.left != null || curr.right.right != null) keepgoing = true;
                } else {
                    sb.append("null,");
                }
            }
        }
        return sb.substring(0, sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null;
        
        String[] list = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(list[0])), curr = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for(int i = 1; i < list.length; i += 2) {
            curr = queue.poll();
            
            if(!list[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(list[i]));
                queue.offer(curr.left);
            }
        
            if(!list[i + 1].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(list[i + 1]));
                queue.offer(curr.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));