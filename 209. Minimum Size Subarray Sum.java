// Binary Search Approach O(nlogn)
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for(int i = 1; i < sums.length; i++) sums[i] = sums[i-1] + nums[i-1];
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < sums.length; i++) {
            // i is the starting point, we are going to search the ending point
            // the target is sums[i] + s
            int end = binarySearch(sums, sums[i] + s, i + 1, sums.length - 1);
            if(end == sums.length) break;
            res = Math.min(res, end - i);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    
    // it is '35. search insert position'
    private int binarySearch(int[] nums, int target, int left, int right) {
        while(left <= right) {
            int middle = left + (right - left) / 2;
            if(nums[middle] == target) return middle;
            else if(nums[middle] < target) left = middle + 1;
            else right = middle - 1;
        }
        return left;
    }
}


// Two Pointers Approach O(n)
/*
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
*/