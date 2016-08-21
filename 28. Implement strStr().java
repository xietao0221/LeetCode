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