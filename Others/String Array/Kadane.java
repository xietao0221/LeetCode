// Maximum Subarray Problem (Kadane Algorithm)
// Find the contiguous subarray within a one-dimensional array of numbers which has the largest sum. Could contain negative integers.
public class Solution {
    public KadaneResult kadaneAlgorithm(int[] nums) {
        KadaneResult res = new KadaneResult(0, 0, nums[0]);

        int localStart = 0, localMax = nums[0];
        for(int i = 1; i < nums.length; i++) {
            // find the local maximum
            // localMax = Math.max(localMax + nums[i], nums[i]);
            if(nums[i] > localMax + nums[i]) {
                localMax = nums[i];
                localStart = i;
            } else {
                localMax += nums[i];
            }

            // find the global maximum
            // globalMax = Math.max(globalMax, localMax);
            if(localMax > res.maxSum) {
                res.maxSum = localMax;
                res.start = localStart;
                res.end = i;
            }
        }
        return res;
    }

    class KadaneResult {
        int maxSum, start, end;
        public KadaneResult(int maxSum, int start, int end) {
            this.maxSum = maxSum;
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return "start: " + start + ", end: " + end + ", maxSum: " + maxSum;
        }
    }
}