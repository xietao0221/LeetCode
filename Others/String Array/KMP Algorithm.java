/*
length of text and pattern is m and n.
create lps array: O(n), search: O(m), so time complexity: O(m + n)
space complexity: O(n)
*/
public class Solution {
    public int kmpAlgorithm(String text, String pattern) {
        char[] textArray = text.toCharArray(), patternArray = pattern.toCharArray();
        int[] lps = longestProperPrefix(patternArray);
        int i = 0, j = 0;
        while(i < textArray.length && j < patternArray.length) {
            if(textArray[i] == patternArray[j]) {
                i++;
                j++;
            } else {
                if(j != 0) j = lps[j - 1];
                else i++;
            }
        }

        if(j == patternArray.length) return i - patternArray.length;
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