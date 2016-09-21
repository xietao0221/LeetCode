/*
https://discuss.leetcode.com/topic/18972/ac-short-java-solution

------------------
0 - 9: 1
10 - 19: 1 + 10
20 - 29: 1
...
90 - 99: 1
------------------
100 - 109: 1 + 10
110 - 119: 1 + 10 + 10
120 - 129: 1 + 10
...
190 - 199: 1 + 10
------------------

(1) for normal numbers(except for 10-19, 110-119...)
one's place: have one 1 every ten numbers -> (n/k)/10 * k where k = 1
ten's place: have ten 1 every one hundred numbers -> (n/k)/10 * k

(2) for special numbers
for every place, if n/k>=1, should plus 10 more, so n/k+8 is a wise choice
*/
public class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        for(long k = 1; k <= n; k *= 10) {
            count += (n / k + 8) / 10 * k + (n / k % 10 == 1 ? n % k + 1 : 0);
        }
        return count;
    }
}