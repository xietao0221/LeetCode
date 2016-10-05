public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        
        char[] sArray = s.toCharArray();
        int[] dp = new int[sArray.length + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for(int i = 2; i < dp.length; i++) {
            if(isValid(sArray, i - 1, i - 1)) dp[i] += dp[i - 1];
            if(isValid(sArray, i - 2, i - 1)) dp[i] += dp[i - 2];
        }
        return dp[dp.length - 1];
    }
    
    private boolean isValid(char[] sArray, int start, int end) {
        if(sArray[start] == '0') return false;
        
        int res = 0;
        if(start == end) res = sArray[start] - '0';
        else res = 10 * (sArray[start] - '0') + (sArray[end] - '0');
        
        return res > 0 && res <= 26;
    }
}