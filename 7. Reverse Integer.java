public class Solution {
    public int reverse(int x) {
        long res = 0;
        while(x != 0) {
            int tail = x % 10;      // if x < 0, x % 10 < 0
            res = res * 10 + tail;
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
            x /= 10;
        }
        return (int)res;
    }
}