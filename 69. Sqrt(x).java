public class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1) return 1;
        
        int left = 1, right = x, middle = 0, res = 0;
        while(left < right) {
            middle = left + (right - left) / 2;
            if(middle > x / middle) {
                right = middle;
            } else {
                res = middle;
                left = middle + 1;
            }
        }
        return res;
    }
}