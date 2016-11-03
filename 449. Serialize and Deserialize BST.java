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
        if(root == null) return "# ";
        
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(" ");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(" ");
        return deserializeHelper(dataArray, new int[]{0});
    }
    
    private TreeNode deserializeHelper(String[] array, int[] pos) {
        String curr = array[pos[0]++];

        if(curr.equals("#")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(curr));
        root.left = deserializeHelper(array, pos);
        root.right = deserializeHelper(array, pos);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));