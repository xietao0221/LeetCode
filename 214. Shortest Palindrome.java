public class Solution {
    public String shortestPalindrome(String s) {
        char[] array = s.toCharArray();
        int anchor = s.length() - 1, start = 0, end = anchor;
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