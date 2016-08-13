// Bit Manipulation Approach
public class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;
        for(int i=0; i<nums.length; i++) {
            result ^= i ^ nums[i];
        }
        return result ^ nums.length;
    }
}

// Union and Find like Approach
/*
public class Solution {
    public int missingNumber(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            while(nums[i] >= 0 && nums[i] < nums.length && nums[nums[i]] != nums[i]) {
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != i) return i;
        }
        return nums.length;
    }
}
*/
