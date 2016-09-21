public class Solution {
    public boolean isPowerOfTwo(int n) {
        return isPowerOfTwoHelper(n, 2);
    }
    
    public boolean isPowerOfTwoHelper(int n, int factor) {
        if(n == 1 || n == 2) return true;
        else if(n < 1) return false;
        
        if(n % factor == 0) {
            n /= factor;
            factor *= factor;
        } else {
            if(n % 2 == 0) factor = 2;
            else return false;
        }
        return isPowerOfTwoHelper(n, factor);
    }
}