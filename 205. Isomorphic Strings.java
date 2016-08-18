// positions[0~255] is for s, positions[256~511] is for t
// save the last seen positions of current characters in both part
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] sArray = s.toCharArray(), tArray = t.toCharArray();
        int [] positions = new int[512];        // 256 * 2

        for(int i = 0; i < sArray.length; i++) {
            char tempS = sArray[i], tempT = tArray[i];
            if(positions[tempS] != positions[tempT + 256]) return false;
            
            // because the default value in the array is 0, so we should add someone to i
            // (Ex. aa -> ab)
            positions[tempS] = i + 1;
            positions[tempT + 256] = i + 1;
        }
        return true;
    }
}

// hash map and hash set
/*
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        char[] sArray = s.toCharArray(), tArray = t.toCharArray();

        for(int i = 0; i < sArray.length; i++) {
            char tempS = sArray[i], tempT = tArray[i];
            if(map.containsKey(tempS)) {
                if(map.get(tempS) != tempT) return false;
            } else {
                map.put(tempS, tempT);
                // check if tempT is mapped before (Ex. ab -> aa)
                if(!set.add(tempT)) return false;
            }   
        }
        return true;
    }
}
*/