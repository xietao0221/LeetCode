public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // have to use int[256] and use count[s.charAt(i)] to represent the char
        int[] count = new int[256];
        int start = 0, res = 0, size = 0;
        for(int end=0; end<s.length(); end++) {
            if(count[s.charAt(end)]++ == 0) size++;
            if(size > k) {
                while(--count[s.charAt(start++)] > 0);  // do nothing inside the while loop
                size--;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}