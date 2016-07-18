public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return wordPatternMatchHelper(map, set, pattern, str, 0, 0);
    }
    
    public boolean wordPatternMatchHelper(Map<Character, String> map, Set<String> set,
                                          String pattern, String str, int patternIndex, int strIndex) {
        if(patternIndex == pattern.length() && strIndex == str.length()) return true;
        if(patternIndex == pattern.length() || strIndex == str.length()) return false;

        boolean res = false;
        for(int i=strIndex; i<=str.length()-(pattern.length()-patternIndex); i++) {
            String currStr = str.substring(strIndex, i+1);
            char currPattern = pattern.charAt(patternIndex);
            if(map.containsKey(currPattern)) {
                if(map.get(currPattern).equals(currStr)) {
                    res |= wordPatternMatchHelper(map, set, pattern, str, patternIndex+1, i+1);
                    if(res) return res;
                }
            } else {
                if(!set.contains(currStr)) {
                    map.put(currPattern, currStr);
                    set.add(currStr);
                    res |= wordPatternMatchHelper(map, set, pattern, str, patternIndex+1, i+1);
                    if(res) {
                        return res;
                    } else {
                        map.remove(currPattern);
                        set.remove(currStr);
                    }
                }
            }
        }
        return false;
    }
}