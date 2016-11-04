// put each number to its right place
public class Solution {
    public int missingNumber(int[] nums) {
        int index = 0;
        while(index < nums.length) {
            if(index == nums[index] || nums[index] >= nums.length) index++;
            else swap(nums, index, nums[index]);
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i) return i;
        }
        return nums.length;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

// Bit Manipulation Approach
// a ^ a = 0; 
// a ^ b = 1 where a != b;
/*
public class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            result ^= i ^ nums[i];
        }
        return result ^ nums.length;
    }
}
*/