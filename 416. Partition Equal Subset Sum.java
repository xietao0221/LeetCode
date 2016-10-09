// Recursive Solution
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) sum += num;
        if(sum % 2 == 1) return false;
        
        return canPartitionHelper(nums, 0, sum / 2);
    }
    
    private boolean canPartitionHelper(int[] nums, int pos, int sum) {
        if(sum < 0) return false;
        if(sum == 0) return true;
        
        for(int i = pos; i < nums.length; i++) {
            if(canPartitionHelper(nums, i + 1, sum - nums[i])) return true;
        }
        return false;
    }
}

// DP Solution, like 'knapsack' or 'coin change'
/*
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) sum += num;
        if(sum % 2 == 1) return false;
        
        boolean[][] dp = new boolean[sum / 2 + 1][nums.length + 1];
        
        // deal with the first row
        for(int j = 0; j < dp[0].length; j++) dp[0][j] = true;
        
        // deal with the first col except for dp[0][0], all are false, don't need to setup
        
        // deal with the rest
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                // choose not to add nums[j - 1]
                dp[i][j] = dp[i][j - 1];
                
                // choose to add nums[j - 1]
                if(i < nums[j - 1]) continue;
                dp[i][j] |= dp[i - nums[j - 1]][j];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
*/