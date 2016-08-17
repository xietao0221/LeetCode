public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE, index1 = words.length - 1, index2 = words.length - 1;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {                            //find word1
                if(word1.equals(word2)) res = Math.min(res, Math.abs(i - index1));
                else res = Math.min(res, Math.abs(i - index2));
                index1 = i;
            }
            
            if(words[i].equals(word2) && !word1.equals(word2)) {    //find word2
                res = Math.min(res, Math.abs(i - index1));
                index2 = i;
            }
        }
        return res;
    }
}