public class Solution {
    public Character findFirstUniqueChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(char c: s.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1) return entry.getKey();
        }
        return null;
    }
}