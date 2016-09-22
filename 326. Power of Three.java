public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n < 3) {
            if(n == 1) return true;
            else return false;
        }
        if(n % 3 != 0) return false;
        return isPowerOfThree(n / 3);
    }
}