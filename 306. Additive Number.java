public class Solution {
    public boolean isAdditiveNumber(String num) {
        // i, j are the length of num1 and num2
        // num1: [0, i); num2: [i, i + j)
        for(int i = 1; i <= num.length() / 2; i++) {
            for(int j = 1; Math.max(i, j) <= num.length() - i - j; j++) {
                if(isValid(num, i, j)) return true;
            }
        }
        return false;
    }

    private boolean isValid(String num, int i, int j) {
        // avoid the leading zeroes
        if((i > 1 && num.charAt(0) == '0') || (j > 1 && num.charAt(i) == '0')) return false;
        
        String xString = num.substring(0, i), yString = num.substring(i, i + j), zString = "";
        Long x = Long.parseLong(xString), y = Long.parseLong(yString), z;
        
        for(int k = i + j; k < num.length(); k += zString.length()) {
            z = x + y;
            zString = z.toString();
            
            if(num.indexOf(zString, k) != k) return false;
            
            x = y;
            y = z;
        }
        return true;
    }
}