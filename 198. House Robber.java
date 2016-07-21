public class Solution {
    public int rob(int[] nums) {
        int yes = 0, no = 0;
        for(int num: nums) {
            // have to store the 'no' first in case this value is changed
            int tmp = no;
            // the current one is not robbed: nothing to do with num, just get the max of 'yes' and 'no'
            no = Math.max(yes, no);
            // the current one is robbed, the previous one must not be robbed, so use the combination of 'no' and num
            yes = tmp + num;
        }
        return Math.max(yes, no);
    }
}