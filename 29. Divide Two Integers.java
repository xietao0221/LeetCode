public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        if(divisor == 1) return dividend;
        
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        int res = 0;
        long dividendLong = Math.abs((long)dividend), divisorLong = Math.abs((long)divisor);
        
        while(dividendLong >= divisorLong) {
            // tmp is the tmporary value of divisor which multiple 2 each loop
            // count is the count of multiple
            long tmp = divisorLong, count = 1;      
            while(dividendLong >= (tmp << 1)) {
                tmp <<= 1;
                count <<= 1;
            }
            dividendLong -= tmp;
            res += count;
        }
        return sign > 0 ? res : -res;
    }
}