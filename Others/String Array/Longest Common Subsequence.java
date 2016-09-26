// https://www.youtube.com/watch?v=NnD96abizww
public class Solution {
    public List<Character> longestCommonSubsequence(String a, String b) {
        char[] aArray = a.toCharArray(), bArray = b.toCharArray();
        int[][] dp = new int[aArray.length + 1][bArray.length + 1];
        List<Character> res = new ArrayList<>();

        // iterate dp matrix
        for(int i = 1; i <= aArray.length; i++) {
            for(int j = 1; j <= bArray.length; j++) {
                if(aArray[i - 1] == bArray[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // output substring
        int row = dp.length - 1, col = dp[0].length - 1;
        while(dp[row][col] != 0) {
            if(dp[row][col] != dp[row - 1][col] && dp[row][col] != dp[row][col - 1]) {
                res.add(0, aArray[row - 1]);
                row--;
                col--;
            } else if(dp[row][col] == dp[row - 1][col]) {
                row--;
            } else {
                col--;
            }
        }
        return res;
    }
}