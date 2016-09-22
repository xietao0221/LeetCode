public class Solution {
    public int maxProduct(String[] words) {
        // calculate the letter used for each word
        int[] bitMap = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                bitMap[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        
        int res = 0;
        for(int i = 0; i < bitMap.length; i++) {
            for(int j = i + 1; j < bitMap.length; j++) {
                if((bitMap[i] & bitMap[j]) == 0) {
                    res = Math.max(words[i].length() * words[j].length(), res);
                }
            }
        }
        return res;
    }
}