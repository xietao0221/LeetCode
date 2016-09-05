public class Solution {
    public int longestSubstring(String s, int k) {
        char[] sArray = s.toCharArray();
        return longestSubstringHelper(sArray, k, 0, sArray.length);
    }
    
    private int longestSubstringHelper(char[] sArray, int k, int start, int end) {
        int[] charSet = new int[26];
        for(int i = start; i < end; i++) charSet[sArray[i] - 'a']++;
        
        int left = start, right = start, res = 0;
        while(right < end) {
            while(left < end && charSet[sArray[left] - 'a'] < k) left++;
            
            right = left;
            while(right < end && charSet[sArray[right] - 'a'] >= k) right++;
            
            if(left == start && right == end) return end - start;
            
            res = Math.max(res, longestSubstringHelper(sArray, k, left, right));
            left = right;
        }
        return res;
    }
}