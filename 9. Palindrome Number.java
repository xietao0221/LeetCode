public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        
        int len = 1, temp = x;
        while(temp > 9) {
            temp = temp / 10;
            len++;
        }
        
        for(int i = 0; i < len / 2; i++) {
            if(getIthDigit(x, len, i) != getIthDigit(x, len, len - 1 - i)) return false;
        }
        return true;
    }
    
    public int getIthDigit(int x, int len, int index) {
        while(index-- > 0) x = x / 10;
        return x % 10;
    }
}