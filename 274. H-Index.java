// https://discuss.leetcode.com/topic/23307/my-o-n-time-solution-use-java/33
// bucket sort
public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] bucket = new int[len + 1];
        
        for(int i = 0; i < len; i++) {
            if(citations[i] >= len) bucket[len]++;
            else bucket[citations[i]]++;
        }
        
        int res = 0;
        for(int i = len; i >= 0; i--) {
            res += bucket[i];
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