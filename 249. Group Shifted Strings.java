public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String word: strings) {
            String key = hashCode(word);
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(word);
        }
        return new ArrayList<>(map.values());
    }
    
    private String hashCode(String word) {
        StringBuilder code = new StringBuilder();
        code.append('a');
        int diff = word.charAt(0) - 'a';
        for(int i = 1; i < word.length(); i++) {
            code.append((word.charAt(i) + 26 - diff) % 26);
        }
        return code.toString();
    }
}