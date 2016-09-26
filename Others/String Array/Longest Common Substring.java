// https://www.youtube.com/watch?v=BysNXJHzCEs
public class Solution {
    public List<Character> longestCommonSubstring(String a, String b) {
        char[] aArray = a.toCharArray(), bArray = b.toCharArray();
        int[][] dp = new int[aArray.length + 1][bArray.length + 1];
        int res = 0;
        int[] resIndex = new int[2];
        List<Character> list = new ArrayList<>();

        // iterate dp matrix
        for(int i = 1; i <= aArray.length; i++) {
            for(int j = 1; j <= bArray.length; j++) {
                if(aArray[i - 1] == bArray[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if(dp[i][j] > res) {
                        res = dp[i][j];
                        resIndex[0] = i;
                        resIndex[1] = j;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        // output substring
        int row = resIndex[0], col = resIndex[1];
        while(dp[row][col] != 0) {
            list.add(0, aArray[row - 1]);
            row--;
            col--;
        }
        return list;
    }
}