// Recursive Approach
public class Solution {
    private int count = 0;

    int findLovelyNumber(int a, int b){
        int num, numSet = 0;

        // the first digit cannot be 0
        for (int i = 1; i <= 9; i++) {
            if (((numSet >> i) & 1)  == 1) continue;        // avoid duplicate

            numSet |= (1 << i);
            num = i;

            findLovelyNumberHelper(num, numSet, a, b);

            numSet &= (~(1 << i));
        }
        return count;
    }


    private void findLovelyNumberHelper(int num, int numSet, int a, int b) {
        if (num > b) return;
        if (num >= a && num <= b) count++;

        for (int i = 0; i <= 9; i++) {
            if (((numSet >> i) & 1)  == 1) continue;        // avoid duplicate

            numSet |= (1 << i);
            num = num * 10 + i;

            findLovelyNumberHelper(num, numSet, a, b);

            numSet &= (~(1 << i));                          // backtracking
            num /= 10;
        }
    }
}

// DP Approach
public class Solution {
    public int findLovelyNumber(int a, int b){
        int[] dp = new int[11];
        dp[0] = 1;
        dp[1] = 10;
        int base = 9, res = 10;
        for(int i = 2; i < 11; i++) {
            base *= 11 - i;
            dp[i] = dp[i - 1] + base;
        }
        return findLovelyNumberHelper(b, dp) - findLovelyNumberHelper(a - 1, dp);    
    }

    private int findLovelyNumberHelper(int higher, int[] dp) {
        if(higher <= 0) return 0;
        int digit = 0, count = 0;
        while(higher > 0) {
            count += (higher % 10) * dp[digit++];
            higher /= 10;
        }
        return count;
    }
}