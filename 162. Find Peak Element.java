// Binary Search
public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int middle = left + (right - left) / 2;
            if(nums[middle] < nums[middle + 1]) left = middle + 1;
            else right = middle;
        }
        return left;
    }
}

// brute force
/*
public class Solution {
    public int findPeakElement(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1]) return i-1;
        }
        return nums.length - 1;
    }
}
*/