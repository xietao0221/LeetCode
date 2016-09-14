public class Solution {
    private char[][] pairs = new char[][]{{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    private int count = 0;
    private String low, high;
    
    public int strobogrammaticInRange(String low, String high) {
        this.low = low;
        this.high = high;
        
        for(int len = low.length(); len <= high.length(); len++) {
            strobogrammaticInRangeHelper(len, new char[len], 0, len - 1);    
        }
        return count;
    }
    
    private void strobogrammaticInRangeHelper(int len, char[] sArray, int left, int right) {
        if(left > right) {
            // use comparison of string rather than the comparison of integer/long after parsing
            String curr = new String(sArray);
            if((curr.length() == low.length() && curr.compareTo(low) < 0) || 
                (curr.length() == high.length() && curr.compareTo(high) > 0)) return;
            count++;
            return;
        }
        
        for(char[] pair: pairs) {
            sArray[left] = pair[0];
            sArray[right] = pair[1];
            
            // avoid the first digit is 0
            if(len > 1 && sArray[0] == '0') continue;
            
            // if only one digit left, we cannot choose 6 or 9
            if(left == right && (sArray[left] == '6' || sArray[left] == '9')) continue;
            
            strobogrammaticInRangeHelper(len, sArray, left + 1, right - 1);
        }
    }
}