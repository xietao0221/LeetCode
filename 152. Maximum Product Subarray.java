public class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0], maxEndingHere = nums[0], minEndingHere = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] >= 0) {
                maxEndingHere = Math.max(maxEndingHere * nums[i], nums[i]);
                minEndingHere = Math.min(minEndingHere * nums[i], nums[i]);
            } else {
                int tmp = maxEndingHere;
                maxEndingHere = Math.max(minEndingHere * nums[i], nums[i]);
                minEndingHere = Math.min(tmp * nums[i], nums[i]);
            }
            res = Math.max(res, maxEndingHere);
        }
        return res;
    }
}