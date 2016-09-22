// https://discuss.leetcode.com/topic/58334/a-couple-of-java-solutions-with-explanations/2
// remove as many 1 as possible
public class Solution {
    public int integerReplacement(int n) {
        int res = 0;
        while(n != 1) {
            if((n & 1) == 0) {
                n >>>= 1;
            } else {
                if(n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) n--;
                else n++;
            }
            res++;
        }
        return res;
    }
}