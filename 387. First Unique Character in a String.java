public class Solution {
    public int firstUniqChar(String s) {
        char[] sArray = s.toCharArray();
        int[] charSet = new int[256];
        for(char c: sArray) charSet[c]++; 
        for(int i = 0; i < sArray.length; i++) {
            if(charSet[sArray[i]] == 1) return i;
        }
        return -1;
    }
}