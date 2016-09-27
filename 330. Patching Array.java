/*
nums = [1,2,3,9]
(1) after we encouter 1, [1, 1] is patched, max = 1.
(2) after we encouter 2, [1, 1 + 2] is patched, max = 3.
(3) after we encouter 3, [1, 1 + 2 + 3] is patched, max = 6.
(4) we need to add 7, [1, 1 + 2 + 3 + 7] is patched, max = 13.
(5) after we encouter 9, [1, 1 + 2 + 3 + 7 + 9] is patched, max = 22.
*/
public class Solution {
    public int minPatches(int[] nums, int n) {
        long max = 0;
        int index = 0, res = 0;
        while(max < n) {
            if(index < nums.length && max + 1 >= nums[index]) {
                // index should be valid, and max + 1 should cover nums[i]
                max += nums[index++];
            } else {
                // at this time, if we keep adding nums[i], there must be a gap in between
                // so we add (max + 1)
                max += max + 1;
                res++;
            }
        }
        return res;
    }
}