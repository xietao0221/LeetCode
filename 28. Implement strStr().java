// KMP
public class Solution {
    public int strStr(String haystack, String needle) {
        char[] text = haystack.toCharArray(), pattern = needle.toCharArray();
        int[] lps = longestProperPrefix(pattern);
        int i = 0, j = 0;
        while(i < text.length && j < pattern.length) {
            if(text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                if(j != 0) j = lps[j - 1];
                else i++;
            }
        }
        
        if(j == pattern.length) return i - pattern.length;
        else return -1;
    }
    
    private int[] longestProperPrefix(char[] pattern) {
        int[] lps = new int[pattern.length];
        int j = 0, i = 1;
        while(i < pattern.length) {
            if(pattern[i] == pattern[j]) {
                lps[i++] = ++j;
            } else {
                if(j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return lps;
    }
}

// brute force
/*
public class Solution {
    public int strStr(String haystack, String needle) {
        char[] haystackArray = haystack.toCharArray(), needleArray = needle.toCharArray();
        int start = 0, end = 0;
        while(true) {
            if(end == needleArray.length) return start;
            if(start + end == haystackArray.length) break;
            if(haystackArray[start + end] == needleArray[end]) {
                end++;
            } else {
                end = 0;
                start++;
            } 
        }
        return -1;
    }
}
*/