// https://www.youtube.com/watch?v=l3hda49XcDE&list=PLrmLmBdmIlpuE5GEMDXWf0PWbBD9Ga1lO&index=1
public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        char[] sArray = s.toCharArray(), pArray = p.toCharArray();
        
        // s and p are all empty, they match
        dp[0][0] = true;
        
        // deal with patterns like p = '*' which has nothing before *
        if(pArray.length > 0 && pArray[0] == '*') return false;
        
        //  deal with first row and first col, the default value is 'false', so nothing to do with it
        
        // deal with patterns like 'a*' or 'a*b*' or 'a*b*c*'
        for(int j = 1; j < n + 1; j++) {
            if(pArray[j-1] == '*') dp[0][j] = dp[0][j-2];
        }
        
        // the index of dp is 1 larger than s or p's index, because index 0 is for the empty string
        for(int i = 1; i < m + 1; i++) {
            // j from 1: the first col is always false(default is false), because pattern is empty but text is not
            for(int j = 1; j < n + 1; j++) {
                if(pArray[j-1] == sArray[i-1] || pArray[j-1] == '.') {
                    // p and s is the same, or they can be seen as the same because of '.'
                    dp[i][j] = dp[i-1][j-1];
                } else if(pArray[j-1] == '*') {
                    // * matches 0 of the preceding element, so 'a*' these two characters can be removed
                    dp[i][j] |= dp[i][j-2];
                    
                    // * matches >= 1 of preceding element
                    // we need to compare j - 2 with i - 1, because * only match the preceding element
                    // this i can be removed
                    if(pArray[j-2] == sArray[i-1] || pArray[j-2] == '.') {
                        dp[i][j] |= dp[i-1][j];     // don't forget to 'or' itself
                    }
                } else {
                    // p and s are regular characters, and they are not the same;
                    // or the first column which represents pattern is empty but text is not
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }
}