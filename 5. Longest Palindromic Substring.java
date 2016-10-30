// Solution 1
public class Solution {
    private int max = 0, start = 0, end = 0;
    
    public String longestPalindrome(String s) {
        char[] sArray = s.toCharArray();
        for(int i = 0; i < sArray.length - 1; i++) {
            longestPalindromeHelper(sArray, i, i);
            longestPalindromeHelper(sArray, i, i + 1);
        }
        return s.substring(start, end + 1);
    }
    
    private void longestPalindromeHelper(char[] sArray, int left, int right) {
        while(left >= 0 && right < sArray.length && sArray[left] == sArray[right]) {
            left--;
            right++;
        }
        
        if(right - left - 1 > max) {
            max = right - left - 1;
            start = left + 1;
            end = right - 1;
        }
    }
}

// Solution 2: DP
/*
public class Solution {
    public String longestPalindrome(String s) {
        char[] sArray = s.toCharArray();
        boolean[][] dp = new boolean[sArray.length][sArray.length];
        int res = 0, resStart = 0, resEnd = 0;
        
        for(int end = 0; end < sArray.length; end++) {
            for(int start = 0; start <= end; start++) {
                if(sArray[start] == sArray[end] && (end - start <= 2 || dp[start + 1][end - 1])) {
                    dp[start][end] = true;
                    if(end - start + 1 > res) {
                        res = end - start + 1;
                        resStart = start;
                        resEnd = end;
                    }
                }
            }
        }
        return s.substring(resStart, resEnd + 1);
    }
}
*/