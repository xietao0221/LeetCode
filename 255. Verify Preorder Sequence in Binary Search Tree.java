// use stack
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int lowSoFar = Integer.MIN_VALUE;
        for(int n: preorder) {
            if(n < lowSoFar) return false;      // important
            
            // if someone is larger than previous one, this one is kind of right branch
            // pop out until get this n's root, which is the lowest value so far
            // anything later cannot smaller than this lowest value
            while(!stack.isEmpty() && n > stack.peek()) {
                lowSoFar = stack.pop();
            }
            
            // always continuously push left branch without pop out anything.
            stack.push(n);
        }
        return true;
    }
}

// use binary search, result in memory overflow
/*
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) return true;
        return verifyPreorderHelper(preorder, 0, preorder.length - 1);
    }
    
    private boolean verifyPreorderHelper(int[] preorder, int left, int right) {
        if(left >= right) return true;
        
        Integer rightBranch = null;
        for(int i = left + 1; i <= right; i++) {
            if(rightBranch == null && preorder[i] > preorder[left]) rightBranch = i;
            if(rightBranch != null && preorder[i] < preorder[rightBranch]) return false;
        }
        
        if(rightBranch == null) {
            return verifyPreorderHelper(preorder, left + 1, right);
        } else {
            return verifyPreorderHelper(preorder, left + 1, rightBranch - 1) && 
                verifyPreorderHelper(preorder, rightBranch, right);
        }
    }
}
*/