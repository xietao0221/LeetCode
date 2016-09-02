/*
f(i) means the numbers with unique digits with length equals i
f(1): 10 ==> 0,1,2,3,4,5,6,7,8,9
f(2): 81 ==> the first digits choosen from 1 through 9, and the second digits choose from 0 through 9 but different with the first one
f(3): f(2) * 8 ==> the first two difits is choosen, and the range of third one is one smaller.
f(4): f(3) * 7;
f(10): f(9) * 1
f(11): 0
answer = f(1) + f(2) + ... + f(n)
*/
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        if(n == 1) return 10;
        if(n == 2) return 91;
        
        int i = 2, base = 81, res = 91;
        while(++i <= n) {
            base *= 11 - i;
            res += base;
        }
        return res;
    }
}