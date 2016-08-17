public class WordDistance {
    private Map<String, ArrayList<Integer>> map;
    
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            if(!map.containsKey(words[i])) map.put(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1), list2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for(int i: list1) {
            for(int j: list2) {
                res = Math.min(res, Math.abs(i - j));
            }
        }
        return res;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");