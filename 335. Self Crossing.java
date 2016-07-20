// https://discuss.leetcode.com/topic/38014/java-oms-with-explanation
public class Solution {
    public boolean isSelfCrossing(int[] x) {
        for(int i=3; i<x.length; i++) {
            // 1st line crosses the 4th line
            // x1 >= x3 && x4 >= x2
            if(x[i-3] >= x[i-1] && x[i] >= x[i-2]) return true;
            
            // 1st line meets the 4th line
            // x1 + x5 >= x3 && x2 = x4
            if(i >= 4) {
                if((x[i-4] + x[i] >= x[i-2]) && (x[i-3] == x[i-1])) return true;
            }
            
            // 1st line crosses the 6th line
            // x1 + x5 >= x3 && x3 >= x5 && x2 + x6 >= x4 && x2 <= x4
            if(i >= 5) {
                if((x[i-5] + x[i-1] >= x[i-3]) && (x[i-3] >= x[i-1]) && 
                    (x[i-4] + x[i] >= x[i-2]) && (x[i-4] <= x[i-2])) return true;
            }
        }
        return false;
    }
}