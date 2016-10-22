// O(n) Solution
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] charSet = new int[256];
        int left = 0, right = 0, count = 0, res = 0;
        while(right < s.length()) {
            if(charSet[s.charAt(right++)]++ == 0) count++;
            while(count > k) {
                if(--charSet[s.charAt(left++)] == 0) count--;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}

// HashMap and TreeMap Solution: if input is a data stream and k is very large
// we have to use map to compress data
/*
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k == 0) return 0;
        
        // when shrink the window, we need to remove one characters whose last occrance is the smallest
        // in order to shrink as small as possible, we have to save all characters' last occrance in the window
        TreeMap<Integer, Character> lastOccrance = new TreeMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, res = 1;
        for(right = 0; right < s.length(); right++) {
            char in = s.charAt(right);

            // ensure the window size
            while(window.size() == k && !window.containsKey(in)) {
                // find the smallest last occrance index, we need to remove this character
                int outIndex = lastOccrance.firstKey();
                
                // remove them all from both map
                window.remove(lastOccrance.get(outIndex));
                lastOccrance.remove(outIndex);
                
                // must be outIndex + 1, not ++
                left = outIndex + 1;
            }
            
            // now it's safe to add new incoming character, we need to update both maps
            if(window.containsKey(in)) lastOccrance.remove(window.get(in));
            lastOccrance.put(right, in);
            window.put(in, right);
            
            // each step, we calculate the res
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
*/