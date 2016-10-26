// https://discuss.leetcode.com/topic/64624/concise-easy-to-understand-java-5ms-solution-with-explaination
public class Solution {
    public int findKthNumber(int n, int k) {
        k--;
        int res = 1;
        while(k > 0) {
            int steps = calSteps(res, res + 1, n);
            if(steps <= k) {
                k -= steps;
                res += 1;
            } else {
                k -= 1;
                res *= 10;
            }
        }
        return res;
    }
    
    private int calSteps(long left, long right, int n) {
        int steps = 0;
        while(left <= n) {
            steps += Math.min(right, n + 1) - left;
            left *= 10;
            right *= 10;
        }
        return steps;
    }
}