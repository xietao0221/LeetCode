// https://discuss.leetcode.com/topic/51353/simple-dp-solution-with-explanation
// iterative approach
public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int j=2; j<=n; j++) {
            for(int i=j-1; i>=1; i--) {
                int min = Integer.MAX_VALUE;
                for(int k=i+1; k<j; k++) {
                    int max = k + Math.max(dp[i][k-1], dp[k+1][j]);
                    min = Math.min(min, max);
                }
                dp[i][j] = i+1==j ? i : min;
            }
        }
        return dp[1][n];
    }
}

// recursive approach
/*
public class Solution {
    public int getMoneyAmount(int n) {
        int[][] memo = new int[n+1][n+1];
        return getMoneyAmountHelper(memo, 1, n);
    }
    
    public int getMoneyAmountHelper(int[][] memo, int start, int end) {
        if(start >= end) return 0;
        if(memo[start][end] != 0) return memo[start][end];
        int res = Integer.MAX_VALUE;
        for(int i=start; i<=end; i++) {
            // result_when_pick_x = x + max(memo[i ~ x-1], memo[x+1, j])
            // the max means whenever you choose a number, the feedback is always bad 
            // and therefore leads you to a worse branch.
            int tmp = i + Math.max(getMoneyAmountHelper(memo, start, i-1), getMoneyAmountHelper(memo, i+1, end));
            
            // memo[i ~ j] = min(xi, ... ,xj)
            // min makes sure that you are minimizing your cost.
            res = Math.min(tmp, res);
        }
        memo[start][end] = res;
        return res;
    }
}
*/