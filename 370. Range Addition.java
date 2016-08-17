/*
https://discuss.leetcode.com/topic/49691/java-o-k-n-time-complexity-solution
+0 +0 +0 +0 +0
    +2       -2
      +3
-2       +2
-2 +0 +3 +5 +3
*/
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int[] update: updates) {
            int start = update[0], end = update[1], value = update[2];
            res[start] += value;
            if(end < length - 1) res[end+1] -= value;
        }
        
        int sum = res[0];
        for(int i = 1; i < length; i++) {
            res[i] += res[i-1];
        }
        return res;
    }
}