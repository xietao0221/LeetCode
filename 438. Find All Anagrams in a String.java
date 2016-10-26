public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() == 0 || p == null || p.length() == 0) return new ArrayList<>();
        
        List<Integer> res = new ArrayList<>();
        char[] sArray = s.toCharArray(), pArray = p.toCharArray();
        int[] charSet = new int[26];
        for(char c: pArray) charSet[c - 'a']++;
    
        int left = 0, right = 0, count = pArray.length;
        while(right < sArray.length) {
            if(--charSet[sArray[right++] - 'a'] >= 0) count--;
            if(count == 0) res.add(left);
            if(right - left == pArray.length && charSet[sArray[left++] - 'a']++ >= 0) count++;
        }
        return res;
    }
}