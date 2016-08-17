public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE, index1 = words.length - 1, index2 = words.length - 1;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                res = Math.min(res, Math.abs(i - index2));
                index1 = i;
            }
            
            if(words[i].equals(word2)) {
                res = Math.min(res, Math.abs(i - index1));
                index2 = i;
            }
        }
        return res;
    }
}