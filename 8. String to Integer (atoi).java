public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        char[] sArray = str.trim().toCharArray();
        if(sArray.length == 0) return 0;
        
        int index = 0, sign = 1, res = 0;
        
        // deal with sign
        if(sArray[index] == '+' || sArray[index] == '-') {
            sign = sArray[index] == '+' ? 1 : -1;
            index++;
        }
        
        while(index < sArray.length) {
            int digit = sArray[index] - '0';
            
            // deal with bad input
            if(digit < 0 || digit > 9) break;
            
            int tmp = 10 * res + digit;
            
            // deal with overflow
            if(tmp / 10 != res) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            
            index++;
            res = tmp;
        }
        return sign == 1 ? res : -res;
    }
}