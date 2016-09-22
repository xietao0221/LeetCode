/*
https://discuss.leetcode.com/topic/38014/java-oms-with-explanation
only these three cases. 
                i-2
    case 1 : i-1┌─┐
                └─┼─>i
                 i-3
                 
                    i-2
    case 2 : i-1 ┌────┐
                 └─══>┘i-3
                 i  i-4      (i overlapped i-4)

    case 3 :    i-4
               ┌──┐ 
               │i<┼─┐
            i-3│ i-5│i-1
               └────┘
                i-2
*/
public class Solution {
    public boolean isSelfCrossing(int[] x) {
        for(int i = 3; i < x.length; i++) {
            // 1st line crosses the 4th line
            // x1 >= x3 && x4 >= x2
            if(x[i - 3] >= x[i - 1] && x[i] >= x[i - 2]) return true;
            
            // 1st line meets the 4th line
            // x1 + x5 >= x3 && x2 = x4
            if(i >= 4) {
                if((x[i - 4] + x[i] >= x[i - 2]) && (x[i - 3] == x[i - 1])) return true;
            }
            
            // 1st line crosses the 6th line
            // x1 + x5 >= x3 && x3 >= x5 && x2 + x6 >= x4 && x2 <= x4
            if(i >= 5) {
                if((x[i - 5] + x[i - 1] >= x[i - 3]) && (x[i - 3] >= x[i - 1]) && 
                    (x[i - 4] + x[i] >= x[i - 2]) && (x[i - 4] <= x[i - 2])) return true;
            }
        }
        return false;
    }
}