public class Solution {
    public boolean BST2Sum(TreeNode root, int sum) {
        Stack<TreeNode> stack1 = new Stack<>(), stack2 = new Stack<>();
        TreeNode node1 = root, node2 = root;
        while(true) {
            if(node1 != null) {
                stack1.push(node1);
                node1 = node1.left;
            } else if(node2 != null) {
                stack2.push(node2);
                node2 = node2.right;
            } else if(!stack1.isEmpty() && !stack2.isEmpty()) {
                int num1 = stack1.peek().val, num2 = stack2.peek().val;
                if(num1 + num2 == sum) {
                    return true;
                } else if(num1 + num2 < sum) {
                    node1 = stack1.pop();
                    node1 = node1.right;
                } else {
                    node2 = stack2.pop();
                    node2 = node2.left;
                }
            } else {
                break;
            }
        }
        return false;
    }
}