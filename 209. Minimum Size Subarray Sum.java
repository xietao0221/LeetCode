public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int left = 0, right = 0, localSum = 0, res = Integer.MAX_VALUE;
        while(right < nums.length) {
            localSum += nums[right++];
            while(localSum >= s) {
                res = Math.min(res, right - left);
                localSum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}