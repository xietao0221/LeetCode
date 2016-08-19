// backtracking
public class Solution {
    private Map<Character, String> map = new HashMap<>();       // pattern -> str
    private Set<String> set = new HashSet<>();                  // check if str is mapped before
    
    public boolean wordPatternMatch(String pattern, String str) {
        return wordPatternMatchHelper(pattern, str, 0, 0);
    }
    
    public boolean wordPatternMatchHelper(String pattern, String str, int patternIndex, int strIndex) {
        if(patternIndex == pattern.length() && strIndex == str.length()) return true;
        if(patternIndex == pattern.length() || strIndex == str.length()) return false;
        
        // the length of each word is unkonwn, so we need to try
        for(int i = strIndex; i <= str.length() - (pattern.length() - patternIndex); i++) {
            String currStr = str.substring(strIndex, i + 1);
            char currPattern = pattern.charAt(patternIndex);
            
            if(map.containsKey(currPattern)) {
                // the same key maps to different value, this currStr is invalid
                if(!map.get(currPattern).equals(currStr)) continue;
                // this currStr is valid, try the next round recursively
                if(wordPatternMatchHelper(pattern, str, patternIndex + 1, i + 1)) return true;
            } else {
                // currStr is mapped before, but key is not currPattern, this currStr is invalid
                if(set.contains(currStr)) continue;
                
                // create a new mapping
                map.put(currPattern, currStr);
                set.add(currStr);
                
                if(wordPatternMatchHelper(pattern, str, patternIndex + 1, i + 1)) return true;
                
                // backtracking
                map.remove(currPattern);
                set.remove(currStr);
            }
        }
        return false;
    }
}