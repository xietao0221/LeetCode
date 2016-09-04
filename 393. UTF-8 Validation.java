public class Solution {
    public boolean validUtf8(int[] data) {
        int index = 0, tailLen = 0;
        while(index < data.length) {
            tailLen = getTailLen(data[index]);
            
            // it is 1-byte character
            if(tailLen == 0) {
                index++;
                continue;
            }
            
            // the first 8-bit is invalid, or the tail is invalid
            if(tailLen == -1 || !isTailValid(data, index + 1, index + tailLen)) return false;
            index += tailLen + 1;
        }
        return true;
    }
    
    private int getTailLen(int num) {
        if(num <= 127) return 0;
        else if(num <= 191) return -1;
        else if(num <= 223) return 1;
        else if(num <= 239) return 2;
        else if(num <= 247) return 3;
        else if(num <= 251) return 4;
        else if(num <= 254) return 5;
        else return 6;
    }
    
    private boolean isTailValid(int[] data, int start, int end) {
        if(start >= data.length || end >= data.length) return false;
        for(int i = start; i <= end; i++) {
            if(data[i] < 128 || data[i] > 191) return false;
        }
        return true;
    }
}