// https://discuss.leetcode.com/topic/33738/share-my-solution/2
// Merge Sort
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; ++i) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        return countWhileMergeSort(sums, 0, sums.length, lower, upper);
    }

    private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;

        int mid = (start + end) / 2;
        int count = countWhileMergeSort(sums, start, mid, lower, upper)
                + countWhileMergeSort(sums, mid, end, lower, upper);

        int k = mid, j = mid, r = 0, t = mid;
        long[] cache = new long[end - start];

        for (int i = start; i < mid; i++) {
            // find out j, k for calculation of count in [lower, upper]
            while (k < end && sums[k] - sums[i] < lower) k++;
            while (j < end && sums[j] - sums[i] <= upper) j++;
            count += j - k;

            // merge to cache
            while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
            cache[r++] = sums[i];
        }

        // copy back
        System.arraycopy(cache, 0, sums, start, t - start);
        return count;
    }
}