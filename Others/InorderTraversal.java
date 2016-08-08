// iterative approach
static void inorderTraversalIterative(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    while(!stack.isEmpty() || curr != null) {
        if(curr != null) {
            stack.push(curr);
            curr = curr.left;
        } else {
            TreeNode newNode = stack.pop();
            System.out.println(newNode);
            curr = newNode.right;
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