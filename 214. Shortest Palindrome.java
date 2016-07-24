public class Solution {
    public String shortestPalindrome(String s) {
        char[] array = s.toCharArray();
        int start = 0, end = s.length() - 1, anchor = s.length() - 1;
        while(start < end) {
            if(array[start] == array[end]) {
                start++;
                end--;
            } else {
                start = 0;
                anchor--;
                end = anchor;
            }
        }
        return new StringBuilder(s.substring(anchor+1)).reverse().toString() + s;
    }
}