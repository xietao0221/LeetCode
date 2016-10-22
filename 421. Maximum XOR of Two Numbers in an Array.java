// hashset solution
public class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask = 0, res = 0;
        for(int i = 31; i >= 0; i--) {
            mask |= 1 << i;
            
            // extract the ith bit, and put it into set
            Set<Integer> set = new HashSet<>();
            for(int num: nums) set.add(num & mask);

            // the ith bit of tmpRes is 1: 1 ^ 0 = 1, 1 ^ 1 = 0
            // so if set has a and a ^ tmpRes, this bit i is valid, should be in the final result
            int tmpRes = res | (1 << i);
            for(int prefix: set) {
                if(set.contains(prefix ^ tmpRes)) {
                    res = tmpRes;
                    break;
                }
            }
        }
        return res;
    }
}

// trie solution
/*
public class Solution {
    public int findMaximumXOR(int[] nums) {
        Node node = buildTrie(nums);
        return find(node, node, 30, 0);
    }

    private Node buildTrie(int[] nums) {
        Node root = new Node();
        int mask = 1 << 30;
        for(int num: nums) root = insert(num, mask, root);
        return root;
    }

    private Node insert(int num, int mask, Node node) {
        if (node == null) node = new Node();

        if (mask == 0) {
            node.val = num;
            return node;
        }

        // current bit is one
        if ((num & mask) != 0) {
            node.right = insert(num, mask >> 1, node.right);
        } else {
            node.left = insert(num, mask >> 1, node.left);
        }

        return node;
    }

    private int find(Node p, Node q, int count, int max) {
        if (count < 0) return max;

        if (p.hasLeft() && p.hasRight() && q.hasLeft() && q.hasRight()) {
            return Math.max(find(p.left, q.right, count - 1, max | (1 << count)), 
                    find(p.right, q.left, count - 1, max | (1 << count)));
        } else if (p.hasLeft() && q.hasRight()) {
            return find(p.left, q.right, count - 1, max | (1 << count));
        } else if (p.hasRight() && q.hasLeft()) {
            return find(p.right, q.left, count - 1, max | (1 << count));
        } else if (p.hasRight() && q.hasRight()) {
            return find(p.right, q.right, count - 1, max);
        } else {
            return find(p.left, q.left, count - 1, max);
        }
    }

    class Node {
        int val;
        Node left, right;

        boolean hasLeft() {
            return left != null;
        }

        boolean hasRight() {
            return right != null;
        }
    }
}
*/