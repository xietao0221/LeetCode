// https://discuss.leetcode.com/topic/32575/easiest-java-dp-solution-97-36
public class Solution {
    public int minCut(String s) {
        // cut[i] is the min-cut of string ending at i
        int[] cut = new int[s.length()];
        
        // palindrome[i][j] represents whether s[i, j] is palindrome
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        
        // end:    [0, s.length() - 1]
        // start:  [0, end]
        for(int end = 0; end < s.length(); end++) {
            int min = Integer.MAX_VALUE;
            for(int start = 0; start <= end; start++) {
                if(s.charAt(start) == s.charAt(end) && (start + 1 > end - 1 || palindrome[start + 1][end - 1])) {
                    palindrome[start][end] = true;
                    
                    if(start == 0) min = 0;
                    else min = Math.min(min, 1 + cut[start - 1]);
                }
            }
            cut[end] = min;
        }
        return cut[s.length() - 1];
    }
}


// https://www.youtube.com/watch?v=lDYIvtBVmgo
// This solution results in TLE, just read it and don't use it.
/*
public class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[][] cut = new int[n][n], palindrome = new int[n][n];
        char[] sArray = s.toCharArray();
        
        for(int len = 0; len < n; len++) {
            for(int start = 0; start + len < n; start++) {
                int end = start + len;
                if(palindrome[start][end] == 1 || isPalindrome(sArray, start, end, palindrome)) {
                    cut[start][end] = 0;
                } else {
                    int localMin = Integer.MAX_VALUE;
                    for(int mid = start; mid < end; mid++) {
                        localMin = Math.min(localMin, cut[start][mid] + cut[mid + 1][end]);
                    }
                    cut[start][end] = 1 + localMin;
                }
            }
        }
        return cut[0][n - 1];
    }
    
    public boolean isPalindrome(char[] sArray, int start, int end, int[][] palindrome) {
        int i = start, j = end;
        while(start <= end) {
            if(sArray[start++] != sArray[end--]) {
                palindrome[i][j] = -1;
                return false;
            }
        }
        palindrome[i][j] = 1;
        return true;
    }
}
*/