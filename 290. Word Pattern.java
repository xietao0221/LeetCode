public class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        int index = 0;
        String[] words = str.split(" ");
        if(words.length != pattern.length()) return false;
        
        while(index < pattern.length()) {
            if(map.containsKey(pattern.charAt(index))) {
                if(!map.get(pattern.charAt(index)).equals(words[index])) return false;
            } else {
                if(!set.contains(words[index])) {
                    map.put(pattern.charAt(index), words[index]);   
                    set.add(words[index]);
                } else {
                    return false;
                }
            }
            index++;
        }
        return true;
    }
}