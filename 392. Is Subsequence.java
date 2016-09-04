public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0) return true;
        if(s.length() > t.length()) return false;
        
        char[] sArray = s.toCharArray(), tArray = t.toCharArray();
        int sIndex = 0, tIndex = 0;
        while(sIndex < sArray.length && tIndex < tArray.length) {
            if(sArray[sIndex] == tArray[tIndex++]) sIndex++;
        }
        return sIndex == sArray.length;
    }
}