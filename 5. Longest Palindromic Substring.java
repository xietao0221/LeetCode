public class Solution {
    private int max = 0, start = 0, end = 0;
    public String longestPalindrome(String s) {
        char[] sArray = s.toCharArray();
        for(int i=0; i<sArray.length-1; i++) {
            longestPalindromeHelper(sArray, i, i);
            longestPalindromeHelper(sArray, i, i+1);
        }
        return s.substring(start, end+1);
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