public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] charSet = new int[256];
        int left = 0, right = 0, count = 0, res = 0;
        while(right < s.length()) {
            if(charSet[s.charAt(right++)]++ == 0) count++;
            while(count > k) {
                if(--charSet[s.charAt(left++)] == 0) count--;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}