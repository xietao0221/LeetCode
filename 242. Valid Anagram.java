// unsort
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] charSet = new int[256];
        char[] sArray = s.toCharArray(), tArray = t.toCharArray();
        for(char c: sArray) charSet[c]++;
        for(char c: tArray) {
            if(--charSet[c] < 0) return false;
        }
        return true;
    }
}

// sort
/*
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
    
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        
        for(int i = 0; i < sArray.length; i++) {
            if(sArray[i] != tArray[i]) return false;
        }
        return true;
    }
}
*/