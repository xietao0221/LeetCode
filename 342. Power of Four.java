public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num < 4) {
            if(num == 1) return true;
            else return false;
        }
        if(num % 4 != 0) return false;
        return isPowerOfFour(num / 4);
    }
}