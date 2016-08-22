public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        char[] strArray = str.toCharArray();
        int index = 0, sign = 1, res = 0;
        
        while(strArray[index] == ' ' && index < strArray.length) index++;
        
        if(strArray[index] == '+' || strArray[index] == '-') {
            sign = strArray[index] == '+' ? 1 : -1;
            index++;
        }
        
        while(index < strArray.length) {
            int digit = Character.getNumericValue(strArray[index]);
            if(digit < 0 || digit > 9) break;
            
            // res * 10 + digit > Integer.MAX_VALUE
            if((Integer.MAX_VALUE - digit) / 10 < res) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            index++;
        }
        return res * sign;
    }
}