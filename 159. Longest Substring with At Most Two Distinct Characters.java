// https://leetcode.com/discuss/72701/here-10-line-template-that-can-solve-most-substring-problems
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] charSet = new int[256];
        int left = 0, right = 0, count = 0, res = 0;
        while(right < s.length()) {
            // count represents the number of distinct char in the window
            // each time a distinct char is enclosed in the window, count add by one
            if(charSet[s.charAt(right++)]++ == 0) count++;
            
            // when more than two distinct char in the window, we should shrink the window
            while(count > 2) {
                // we decrease the count when a char is totally removed out of the window(after -- the value is 0)
                if(--charSet[s.charAt(left++)] == 0) count--;
            }
            
            // each round we calculate the max value
            res = Math.max(res, right - left);
        }
        return res;
    }
}