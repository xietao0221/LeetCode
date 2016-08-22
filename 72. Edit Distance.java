// https://www.youtube.com/watch?v=We3YDTzNXEk
// 2-D DP Matrix
public class Solution {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int[][] dp = new int[w1.length + 1][w2.length + 1];
        
        // deal with the first row
        for(int j = 0; j < dp[0].length; j++) dp[0][j] = j;
        
        // deal with the first col
        for(int i = 1; i < dp.length; i++) dp[i][0] = i;
        
        // iterate the rest
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(w1[i - 1] == w2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[w1.length][w2.length];
    }
}

// 1-D DP Matrix
/*
public class Solution {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int[] dp = new int[w2.length + 1];
        
        // deal with the first row
        for(int j = 0; j < dp.length; j++) dp[j] = j;
        
        // iterate the rest
        for(int i = 1; i <= w1.length; i++) {
            int topLeft = dp[0];        // topLeft is the value of previous row
            dp[0] = i;                  // set it to new initial value
            for(int j = 1; j <= w2.length; j++) {
                int top = dp[j];        // save the old value
                if(w1[i - 1] == w2[j - 1]) {
                    dp[j] = topLeft;
                } else {
                    dp[j] = Math.min(topLeft, Math.min(top, dp[j - 1])) + 1;
                }
                topLeft = top;          // restore the old value, but from top to topLeft, because the increasing of j
            }
        }
        return dp[w2.length];
    }
}
*/

// Recursive Approach
/*
public class Solution {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int[][] memo = new int[w1.length + 1][w2.length + 1];
        return minDistanceHelper(w1, w2, 0, 0, memo);
    }
    
    public int minDistanceHelper(char[] w1, char[] w2, int w1Index, int w2Index, int[][] memo) {
        if(w1Index == w1.length) return w2.length - w2Index;
        if(w2Index == w2.length) return w1.length - w1Index;

        if(memo[w1Index][w2Index] != 0) return memo[w1Index][w2Index];

        if(w1[w1Index] == w2[w2Index]) {
            memo[w1Index][w2Index] = minDistanceHelper(w1, w2, w1Index + 1, w2Index + 1, memo);
        } else {
            int opt1 = minDistanceHelper(w1, w2, w1Index + 1, w2Index, memo);       // delete w1
            int opt2 = minDistanceHelper(w1, w2, w1Index, w2Index + 1, memo);       // insert w1
            int opt3 = minDistanceHelper(w1, w2, w1Index + 1, w2Index + 1, memo);   // change w1
            memo[w1Index][w2Index] = Math.min(opt1, Math.min(opt2, opt3)) + 1;
        }
        return memo[w1Index][w2Index];
    }
}
*/