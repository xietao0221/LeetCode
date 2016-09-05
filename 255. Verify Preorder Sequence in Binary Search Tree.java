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