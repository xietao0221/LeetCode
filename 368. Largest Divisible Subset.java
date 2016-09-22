/*
https://discuss.leetcode.com/topic/49456/c-solution-with-explanations/2

Given a set of integers that satisfies the property that each pair of integers inside the set are 
mutually divisible, for a new integer S, S can be placed into the set as long as it can divide the 
smallest number of the set or is divisible by the largest number of the set.

Ex. Set = {4, 8, 16}
(1) 2 can divide the smallest number 4
(2) 32 can be divided by the largest number 16
*/
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length < 1) return new ArrayList<>();
        
        int[] dp = new int[nums.length], parent = new int[nums.length];
        int size = 0, index = 0;
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);              // must sort the array
        
        // the starting point
        for(int i = nums.length - 1; i >= 0; i--) {
            // the ending point
            for(int j = i; j < nums.length; j++) {
                // regard j as the smallest element in the potential subset, 
                // if nums[j] % nums[i] == 0, i can be added to it
                if(nums[j] % nums[i] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                    
                    // check global-max
                    if(dp[i] > size) {
                        size = dp[i];
                        index = i;      // index saves the smallest index of potential result
                    }
                }
            }
        }
        
        // output the result
        for(int i = 0; i < size; i++) {
            res.add(nums[index]);
            index = parent[index];
        }
        return res;
    }
}