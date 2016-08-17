public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        Integer index1 = null, index2 = null;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                index1 = i;
                if(index2 != null) res = Math.min(res, Math.abs(index1 - index2));
            }
            
            if(words[i].equals(word2)) {
                index2 = i;
                if(index1 != null) res = Math.min(res, Math.abs(index1 - index2));
            }
        }
        return res;
    }
}