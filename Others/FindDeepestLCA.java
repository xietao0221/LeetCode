/*
Example 1: return 3
    1
   /  \
  2    3
      /  \
     4    5

Example 2: return 6
    1
   /  \
  2    3
        \
         6

Example 3: return 1
      1
    /  \
   2    3
  /    /  \
 4    5    6
*/
// Recursive Approach
public class Solution {
    public TreeNode findDeepestLCA(TreeNode root) {
        NodewithHeight res = findDeepestLCAHelper(root);
        return res.node;
    }

    private NodewithHeight findDeepestLCAHelper(TreeNode root) {
        if(root == null) return new NodewithHeight(0, null);

        NodewithHeight left = findDeepestLCAHelper(root.left);
        NodewithHeight right = findDeepestLCAHelper(root.right);

        if(left.node == null && right.node == null) {
            return new NodewithHeight(1, root);
        } else if(left.node == null) {
            right.height += 1;
            return right;
        } else if(right.node == null) {
            left.height += 1;
            return left;
        } else {
            if(left.height == right.height) {
                left.height += 1;
                left.node = root;
                return left;
            } else if(left.height < right.height) {
                right.height += 1;
                return right;
            } else {
                left.height += 1;
                return left;
            }
        }
    }

    class NodewithHeight {
        public int height;
        public TreeNode node;
        public NodewithHeight(int height, TreeNode node) {
            this.height = height;
            this.node = node;
        }
    }
}


// Iterative Approach
public class Solution {
    public TreeNode findDeepestLCA(TreeNode root) {
        if(root == null) return null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            LinkedList<TreeNode> nextQueue = new LinkedList<>(), currQueue = new LinkedList<>();
            int size = queue.size();

            while(size-- > 0) {
                TreeNode curr = queue.poll();
                currQueue.offer(curr);      // the potential result

                if(curr.left != null) nextQueue.offer(curr.left);
                if(curr.right != null) nextQueue.offer(curr.right);
            }

            if(nextQueue.size() == 0) {
                return findLCA(root, currQueue.pollFirst(), currQueue.pollLast());
            } else if(nextQueue.size() == 1) {
                return nextQueue.poll();
            } else {
                queue = nextQueue;
            }
        }
        return null;
    }

    private TreeNode findLCA(TreeNode root, TreeNode node1, TreeNode node2) {
        if(root == null || root == node1 || root == node2) return root;

        TreeNode left = findLCA(root.left, node1, node2);
        TreeNode right = findLCA(root.right, node1, node2);

        if(left != null && right != null) return root;
        else return left == null ? right : left;
    }
}

