public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length <= 3) {
            int res = 0;
            for(int num: nums) res += num;
            return res;
        }
        
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                int tempSum = nums[i] + nums[left] + nums[right];
                if(tempSum == target) return target;
                if(Math.abs(target - tempSum) < Math.abs(target - sum)) sum = tempSum;
                if(tempSum < target) left++;
                else right--;
                
            }
        }
        return sum;
    }
}