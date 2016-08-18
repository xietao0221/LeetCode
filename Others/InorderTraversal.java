// iterative approach
static void inorderTraversalIterative(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    while(!stack.isEmpty() || curr != null) {
        if(curr != null) {
            stack.push(curr);
            curr = curr.left;
        } else {
            curr = stack.pop();
            System.out.println(curr);
            curr = curr.right;
        }
    }
}

// recursive approach
static void inorderTraversalRecursive(TreeNode root) {
    if(root == null) return;
    inorderTraversalRecursive(root.left);
    System.out.println(root);
    inorderTraversalRecursive(root.right);
}