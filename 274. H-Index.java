// https://discuss.leetcode.com/topic/23307/my-o-n-time-solution-use-java/33
// O(n) Solution
public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] count = new int[len + 1];
        
        for(int i = 0; i < len; i++) {
            if(citations[i] > len) count[len]++;
            else count[citations[i]]++;
        }
        
        int res = 0;
        for(int i = len; i >= 0; i--) {
            res += count[i];
            if(res >= i) return i;
        }
        return 0;
    }
}

// brute force
/*
public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        
        int len = citations.length;
        Arrays.sort(citations);
        for(int i = 0; i < len; i++) {
            if(citations[i] >= len - i) return len - i;
        }
        return 0;
    }
}
*/