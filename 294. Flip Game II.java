public class Solution {
    public boolean canWin(String s) {
        if(s == null || s.length() < 2) return false;
        
        char[] sArray = s.toCharArray();
        return canWinHelper(sArray);
    }
    
    public boolean canWinHelper(char[] sArray) {
        for(int i = 0; i < sArray.length - 1; i++) {
            if(sArray[i] == '+' && sArray[i + 1] == '+') {
                sArray[i] = '-';
                sArray[i+1] = '-';
                
                boolean win = !canWinHelper(sArray);
                
                sArray[i] = '+';
                sArray[i+1] = '+';
                
                if(win) return true;
            }
        }
        return false;
    }
}