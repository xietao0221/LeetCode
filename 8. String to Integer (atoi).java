public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        
        char[] strArray = str.toCharArray();
        int index = 0, sign = 1;
        long res = 0;
        
        // remove leading zeroes
        while(strArray[index] == ' ' && index < strArray.length) index++;
        
        // deal with sign
        if(strArray[index] == '+' || strArray[index] == '-') {
            sign = strArray[index] == '+' ? 1 : -1;
            index++;
        }
        
        while(index < strArray.length) {
            int digit = strArray[index] - '0';
            
            // deal with bad input
            if(digit < 0 || digit > 9) break;
            
            res = 10 * res + digit;
            
            // deal with overflow
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            index++;
        }
        return (int)res * sign;
    }
}