// brute force
public class Solution {
    public int integerBreak(int n) {
        int res = 1;
        for(int split = 2; split <= n; split++) {
            int base = n / split, remain = n % split, tmpRes = 1;
            for(int i = 0; i < split; i++) {
                if(remain-- > 0) tmpRes *= (base + 1);
                else tmpRes *= base;
            }
            res = Math.max(res, tmpRes);
        }
        return res;
    }
}