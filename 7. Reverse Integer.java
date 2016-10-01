// Int Solution
public class Solution {
    public int reverse(int x) {
        boolean sign = x >= 0;
        x = Math.abs(x);
        int res = 0;
        
        while(x != 0) {
            int tmpRes = res * 10 + x % 10;
            x /= 10;
            
            // handle overflow, have to with the help of temporary int
            if(tmpRes / 10 != res) return 0;
            res = tmpRes;
        }
        return sign ? res : -res;
    }
}

// Long Solution
/*
public class Solution {
    public int reverse(int x) {
        boolean sign = x >= 0;
        x = Math.abs(x);

        long res = 0;
        while(x != 0) {
            // get the last digits. if x < 0, x % 10 < 0
            int tail = x % 10;
            x /= 10;
            
            res = res * 10 + tail;
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        }
        return sign ? (int)res : -(int)res;
    }
}
*/