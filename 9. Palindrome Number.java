public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        
        int len = 1, temp = x;
        while(temp > 9) {
            temp /= 10;
            len++;
        }
        
        for(int i = 0; i < len / 2; i++) {
            if(!isValid(x, len, i)) return false;
        }
        return true;
    }
    
    public boolean isValid(int x, int len, int index) {
        int first = 0, second = 0, firstIndex = index, secondIndex = len - 1 - index;
        
        for(int i = 0; i <= len - 1 - index; i++) {
            if(i == firstIndex) first = x % 10;
            else if(i == secondIndex) second = x % 10;
            x /= 10;
        }
        return first == second;
    }
}