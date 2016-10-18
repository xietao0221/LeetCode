public class Solution {
    public int thirdMax(int[] nums) {
        if(nums.length < 3) {
            int res = Integer.MIN_VALUE;
            for(int num: nums) res = Math.max(res, num);
            return res;
        }
        
        int[] res = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for(int num: nums) {
            if(num > res[0] && num != res[1] && num != res[2]) {
                res[0] = num;
                if(res[0] > res[1]) swap(0, 1, res);
                if(res[1] > res[2]) swap(1, 2, res);
            }
        }
        return res[0];
    }
    
    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}