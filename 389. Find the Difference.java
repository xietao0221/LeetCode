public class Solution {
    public char findTheDifference(String s, String t) {
        char[] sArray = s.toCharArray(), tArray = t.toCharArray();
        int[] charSet = new int[26];
        for(char c: sArray) charSet[c - 'a']++;
        for(char c: tArray) {
            if(--charSet[c - 'a'] < 0) return c;
        }
        return 'a';
    }
}