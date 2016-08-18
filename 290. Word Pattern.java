public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] strList = str.split(" ");
        if(strList.length != pattern.length()) return false;
        
        char[] patternArray = pattern.toCharArray();
        for(int i = 0; i < patternArray.length; i++) {
            char key = patternArray[i];
            String value = strList[i];
            if(map.containsKey(key)) {
                if(!map.get(key).equals(value)) return false;
            } else {
                if(!set.add(value)) return false;
                map.put(key, value);
            }
        }
        return true;
    }
}