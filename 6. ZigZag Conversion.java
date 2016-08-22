public class Solution {
    public String convert(String s, int numRows) {
        char[] sArray = s.toCharArray();
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) sb[i] = new StringBuilder();
        
        int i = 0;
        while(i < sArray.length) {
            // going down
            for(int index = 0; index < numRows && i < sArray.length; index++) sb[index].append(sArray[i++]);
            // going up
            for(int index = numRows - 2; index >= 1 && i < sArray.length; index--) sb[index].append(sArray[i++]);
        }
        
        // combine sb[] together
        for(i = 1; i < numRows; i++) sb[0].append(sb[i]);
        return sb[0].toString();
    }
}