// https://leetcode.com/discuss/72701/here-10-line-template-that-can-solve-most-substring-problems
// Sliding Window
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charSet = new int[128];
        int left = 0, right = 0, res = 0;
        while(right < s.length()) {
            // normally, the count could only be 0 and 1, if it is larger than 1
            // we need to shrink the window size(increase the left) to remove the duplicates
            if(charSet[s.charAt(right++)]++ == 1) {
                while(true) {
                    // normally, after --, the value can only be 0, if it is larger than 0
                    // this one is duplicate, we stop shrinking
                    if(--charSet[s.charAt(left++)] == 1) break;
                }
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}

// Hash Table
/*
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, res = 0;
        while(right < s.length()) {
            if(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            } else {
                set.add(s.charAt(right++));
                res = Math.max(res, right - left);
            }
        }
        return res;
    }
}
*/