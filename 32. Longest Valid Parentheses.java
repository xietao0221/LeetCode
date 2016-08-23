// https://leetcode.com/discuss/8092/my-dp-o-n-solution-without-using-stack
// DP Solution
/*
( ( ) ( ) ) 
0 0 2 0 4 6
*/
public class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() < 2) return 0;
        
        // dp[i] represents the valid max length ending at i
        // if s[i] is '(', dp[i] = 0. So dp[n] is not the result, we need to use res to record the max value each step
        int[] dp = new int[s.length()];
        int res = 0;
        
        for(int i = 1; i < s.length(); i++) {
            // Ex. '(' or '((', the default value is 0, so continue
            if(s.charAt(i) == '(') continue;
            
            // s.charAt(i) == ')'
            if(s.charAt(i - 1) == '(') {
                // Ex. '()' or '()'
                dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
            } else {
                // Ex. '(()())'
                int j = i - dp[i - 1] - 1;
                if(j >= 0 && s.charAt(j) == '(') {
                    dp[i] = 2 + dp[i - 1] + (j - 1 >= 0 ? dp[j - 1] : 0);
                }
            }
            
            // update the res
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

// https://leetcode.com/discuss/83428/java-solutions-with-explanation-stack-short-easy-understand
// use stack
/*
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        // in order to use (i - stack.peek()) to get the max length, we have to push this dummy value
        stack.push(-1);
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            // because we have a dummy value and a valid '(', the size is > 1 rather than > 0
            if(s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                // anything popped out is valid, so use i - stack.peek() to get the valid length
                stack.pop();
                res = Math.max(res, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return res;
    }
}
*/