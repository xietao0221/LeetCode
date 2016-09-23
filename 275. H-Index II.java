public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        
        int len = citations.length, left = 0, right = len - 1, mid = 0, res = 0;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(citations[mid] >= len - mid) {
                res = Math.max(res, len - mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}