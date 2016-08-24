// because you could add string in front of the original one, so set the anchor at the end of string
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