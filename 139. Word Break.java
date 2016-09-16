public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        // dp[i] represents s[0,i), so the size of dp is one larger than the size of s
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for(int end = 1; end <= s.length(); end++) {
            for(int start = 0; start < end; start++) {
                // the former part is true && the rest is also true
                if(dp[start] && wordDict.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;      // once this position is true, break out
                }
            }
        }
        return dp[s.length()];
    }
}