public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3) return 0;

        int[] dp = new int[A.length];
        if(A[2] - A[1] == A[1] - A[0]) dp[2] = 1;
        
        int res = dp[2];
        for(int i = 3; i < A.length; i++) {
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]) dp[i] = dp[i - 1] + 1;
            res += dp[i];
        }
        return res;
    }
}