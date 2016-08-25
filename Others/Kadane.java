// Maximum Subarray Problem (Kadane Algorithm)
// Find the contiguous subarray within a one-dimensional array of numbers which has the largest sum. Could contain negative integers.
public class Solution {
    public void kadaneAlgorithm(int[] nums) {
        int[] globalMax = new int[3];       // start, end, sum
        int localMaxStart = 0, localMax = nums[0];
        for(int i = 1; i < nums.length; i++) {
            // find the local maximum
            // localMax = Math.max(localMax + nums[i], nums[i]);
            if(nums[i] > localMax + nums[i]) {
                localMax = nums[i];
                localMaxStart = i;
            }

            // find the global maximum
            // globalMax = Math.max(globalMax, localMax);
            if(localMax > globalMax[2]) {
                globalMax[0] = localMaxStart;
                globalMax[1] = i;
                globalMax[2] = localMax;
            }
        }
        System.out.println("Start: " + globalMax[0] + ", End: " + globalMax[1] + ", Sum: " + globalMax[2]);
    }
}