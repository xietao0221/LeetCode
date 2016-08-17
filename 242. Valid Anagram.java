// unsort
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] charSet = new int[128];
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
        
        char[] arrayS = s.toCharArray();
        char[] arrayT = t.toCharArray();
        Arrays.sort(arrayS);
        Arrays.sort(arrayT);
        
        for(int i = 0; i < arrayS.length; i++) {
            if(arrayS[i] != arrayT[i]) return false;
        }
        return true;
    }
}
*/