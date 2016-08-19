/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// no wrapper class
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> nodeList = new LinkedList<>();
        Queue<Integer> colIndexList = new LinkedList<>();
        int min = 0, max = 0;
        
        nodeList.offer(root);
        colIndexList.offer(0);
        
        while(!nodeList.isEmpty()) {
            TreeNode currNode = nodeList.poll();
            int currIndex = colIndexList.poll();
            if(!map.containsKey(currIndex)) map.put(currIndex, new ArrayList<>());
            map.get(currIndex).add(currNode.val);
            
            if(currNode.left != null) {
                nodeList.offer(currNode.left);
                colIndexList.offer(currIndex - 1);
                min = Math.min(min, currIndex - 1);
            }
            
            if(currNode.right != null) {
                nodeList.offer(currNode.right);
                colIndexList.offer(currIndex + 1);
                max = Math.max(max, currIndex + 1);
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}


// use wrapper calss
/*
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<NodeWithIndex> queue = new LinkedList<>();
        queue.offer(new NodeWithIndex(root, 0));
        while(!queue.isEmpty()) {
            NodeWithIndex temp = queue.poll();
            
            if(!map.containsKey(temp.index)) map.put(temp.index, new ArrayList<>());
            map.get(temp.index).add(temp.node.val);
            
            if(temp.node.left != null) queue.offer(new NodeWithIndex(temp.node.left, temp.index - 1));
            if(temp.node.right != null) queue.offer(new NodeWithIndex(temp.node.right, temp.index + 1));
        }
        return new ArrayList<>(map.values());
    }
    
    class NodeWithIndex {
        public int index;
        public TreeNode node;
        public NodeWithIndex(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}
*/