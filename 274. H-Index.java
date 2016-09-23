// A scientist has index h if h of his/her N papers have at least h citations each, 
// and the other N − h papers have no more than h citations each.
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

// binary search
/*
public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        
        Arrays.sort(citations);
        int len = citations.length, left = 0, right = len - 1, mid = 0, res = 0;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(citations[mid] >= len - mid) {
                res = len - mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
*/