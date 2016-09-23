// http://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/
// a ^ b: get sum
// a & b: get carry
public class Solution {
    public int getSum(int a, int b) {
        if(b == 0) return a;
        int sum = a ^ b;                // the sum of first bit
        int carry = (a & b) << 1;       // the carry of first bit
        return getSum(sum, carry);
    }
}