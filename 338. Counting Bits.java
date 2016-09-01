/*
00 01 | 02 03 | 04 05 06 07 | 08 09 10 11 12 13 14 15
00 01 | 01 02 | 01 02 02 03 | 01 02 02 03 02 03 03 04
*/
public class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        if(num > 0) dp[1] = 1;
        if(num > 1) dp[2] = 1;
        if(num > 2) dp[3] = 2;
        
        int start = 2, len = 2, count = 0, round = 0;
        for(int i = 4; i <= num; i++) {
            dp[i] = dp[start + count] + round;
            if(++count == len) {
                count = 0;
                if(++round == 2) {
                    start += len;
                    len *= 2;
                    round = 0;
                }
            }
        }
        return dp;
    }
}