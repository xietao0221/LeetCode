public class Solution {
    public void reverseWords(char[] s) {
        // reverse the whole string
        reverseWordsHelper(s, 0, s.length - 1);
        
        // reverse each word
        int start = 0, end = start;
        while(end < s.length) {
            // find a valid word
            while(start < s.length && s[start] == ' ') start++;
            end = start;
            while(end < s.length && s[end] != ' ') end++;
            end--;
            
            reverseWordsHelper(s, start, end);
            
            // reset two pointers
            start = ++end;
        }
    }
    
    public void reverseWordsHelper(char[] s, int start, int end) {
        while(start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}