// https://www.youtube.com/watch?v=yCQN096CwWM
public class Solution {
    // 2D Kadane Algorithm
    public Result maxsumRectangle(int[][] matrix) {
        int[] tmpCol = new int[matrix.length];
        Result res = new Result();

        // brute force
        for(int left = 0; left < matrix[0].length; left++) {
            // reset the tmpCol
            Arrays.fill(tmpCol, 0);
            for(int right = left; right < matrix[0].length; right++) {
                for(int i = 0; i < matrix.length; i++) tmpCol[i] += matrix[i][right];

                // 1D Kadane Algorithm
                KadaneResult localMax = kadaneAlgorithm(tmpCol);
                if(localMax.maxSum > res.maxSum) {
                    res.maxSum = localMax.maxSum;
                    res.left = left;
                    res.right = right;
                    res.up = localMax.start;
                    res.low = localMax.end;
                }
            }
        }
        return res;
    }

    // 1D Kadane Algorithm
    private KadaneResult kadaneAlgorithm(int[] nums) {
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

    class Result {
        int maxSum = Integer.MIN_VALUE, left, right, up, low;

        public String toString() {
            return "left: " + left + ", right: " + right + ", up: " + up + ", low: " + low + ", maxSum: " + maxSum;
        }
    }
}