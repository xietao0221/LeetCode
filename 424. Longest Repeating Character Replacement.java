// https://discuss.leetcode.com/topic/63494/java-12-lines-o-n-sliding-window-solution-with-explanation
/*
Since we are only interested in the longest valid substring, our sliding windows need not shrink, 
even if a window may cover an invalid substring. We either grow the window by appending one char 
on the right, or shift the whole window to the right by one. And we only grow the window when the 
count of the new char exceeds the historical max count (from a previous window that covers a valid substring).

That is, we do not need the accurate max count of the current window; we only care if the max count exceeds 
the historical max count; and that can only happen because of the new char.
*/
public class Solution {
    public int characterReplacement(String s, int k) {
        int[] charSet = new int[26];
        char[] sArray = s.toCharArray();
        int left = 0, right = 0, maxCharCount = 0, res = 0;
        
        while(right < sArray.length) {
            // expand the window and save the number of majority number
            maxCharCount = Math.max(maxCharCount, ++charSet[sArray[right++] - 'A']);
            
            // shift window to the right one step
            if(right - left > maxCharCount + k) charSet[sArray[left++] - 'A']--;
            
            res = Math.max(res, right - left);
        }
        return res;
    }
}