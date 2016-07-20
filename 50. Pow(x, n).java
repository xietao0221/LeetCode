public class Solution {
    public double myPow(double x, int n) {
        int absN = Math.abs(n);
        return n>=0 ? myPowHelper(x, absN) : 1/myPowHelper(x, absN);
    }
    
    public double myPowHelper(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        return n%2==0 ? myPowHelper(x*x, n/2) : myPowHelper(x*x, n/2)*x;
    }
}