// DP Approach
public class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

// Recursive Approach
/*
public class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbStairsHelper(n, memo);
    }
    
    public int climbStairsHelper(int index, int[] memo) {
        if(index <= 2) return index;
        if(memo[index] != 0) return memo[index];
        
        memo[index] = climbStairsHelper(index - 1, memo) + climbStairsHelper(index - 2, memo);
        return memo[index];
    }
}
*/