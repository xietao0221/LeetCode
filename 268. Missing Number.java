// put each number to its right place
public class Solution {
    public int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            while(i != nums[i] && nums[i] < nums.length) {
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i) return i;
        }
        return nums.length;
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