// https://discuss.leetcode.com/topic/50489/c-clean-and-short-solution/7
// a ^ 1234567 = (a ^ 1234560) * (a ^ 7) = ((a ^ 123456) ^ 10) * (a ^ 7)
// f(a, b[0, n]) = f(f(a, b[0, n - 1]), 10) * f(a, b[n - 1])
// (a * b) % k = (a % k) * (b % k) % k
public class Solution {
    private int base = 1337;
    
    public int superPow(int a, int[] b) {
        return superPowHelper(a, b, b.length);
    }

    private int superPowHelper(int a, int[] b, int len) {
        if(len == 1) return powMod(a, b[0]);
        return powMod(superPowHelper(a, b, len - 1), 10) * powMod(a, b[len - 1]) % base;
    }

    private int powMod(int a, int b) {
        a %= base;
        int res = 1;
        for(int i = 0; i < b; i++) {
            res *= a;
            res %= base;
        }
        return res;
    }
}