// https://discuss.leetcode.com/topic/28738/java-python-binary-search-o-nlogn-time-with-explanation/2
// binary search: 
// Time Complexity: O(nlogn)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int size = 0;
        
        for(int num: nums) {
            int left = 0, right = size, middle = 0;
            
            // binary search
            while(left < right) {
                middle = left + (right - left) / 2;
                if(dp[middle] < num) left = middle + 1;
                else right = middle;
            }
            
            // left is the right position to 'replace' in dp array
            dp[left] = num;
            if(left == size) size++;
        }
        return size;
    }
}

// https://www.youtube.com/watch?v=CE2b_-XfVDk
// Time Complexity: O(n^2)
/*
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        
        // dp[i] means the number of longest increasing subsequence ending at i
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        // the result subsequence may not ending at the last position
        // so we need a global max to save the res
        int res = 1;
        
        // the ending position
        for(int i = 1; i < nums.length; i++) {
            // the starting position
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
*/