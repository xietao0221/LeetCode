public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String word: strs) {
            char[] wordArray = word.toCharArray();
            Arrays.sort(wordArray);
            String sorted = new String(wordArray);
            if(!map.containsKey(sorted)) map.put(sorted, new ArrayList<>());
            map.get(sorted).add(word);
        }
        return new ArrayList<>(map.values());
    }
}