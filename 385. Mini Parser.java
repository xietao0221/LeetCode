/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        if (s.isEmpty()) return null;
        if (s.charAt(0) != '[') return new NestedInteger(Integer.valueOf(s));
            
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger curr = null;
        int left = 0, right = 0;
        
        for(right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (ch == '[') {
                // push curr to stack and start a new one
                if (curr != null) stack.push(curr);
                curr = new NestedInteger();
                left = right + 1;
            } else if (ch == ']') {
                // if possible, add a new num to the curr
                String num = s.substring(left, right);
                if (num.length() != 0) curr.add(new NestedInteger(Integer.valueOf(num)));
                
                // pop out from stack, add curr to it, and make it as curr
                if (!stack.isEmpty()) {
                    NestedInteger pop = stack.pop();
                    pop.add(curr);
                    curr = pop;
                }
                left = right + 1;
            } else if (ch == ',') {
                // if the previous position is ']', ignore it and move forward
                // otherwise, add it to curr
                if (s.charAt(right-1) != ']') {
                    String num = s.substring(left, right);
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                }
                left = right + 1;
            }
        }
        return curr;
    }
}