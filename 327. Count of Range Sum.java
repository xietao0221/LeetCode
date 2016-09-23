// https://discuss.leetcode.com/topic/34108/summary-of-the-divide-and-conquer-based-and-binary-indexed-tree-based-solutions/4
// Binary Indexed Tree
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length + 1], candidates = new long[3 * sums.length + 1];
        int[] fenwickTree = new int[candidates.length];
        
        int index = 0;
        candidates[index++] = sums[0];
        candidates[index++] = lower + sums[0] - 1;
        candidates[index++] = upper + sums[0];
        for(int i = 1; i < sums.length; i++) {
            sums[i] = nums[i - 1] + sums[i - 1];
            candidates[index++] = sums[i];
            candidates[index++] = lower + sums[i] - 1;
            candidates[index++] = upper + sums[i];
        }
        candidates[index] = Long.MIN_VALUE;
        Arrays.sort(candidates);

        // build the fenwick tree
        for(int i = 0; i < sums.length; i++) {
            updateFenwickTree(fenwickTree, Arrays.binarySearch(candidates, sums[i]), 1);
        }

        int count = 0;
        for(int i = 1; i < sums.length; i++) {
            updateFenwickTree(fenwickTree, Arrays.binarySearch(candidates, sums[i - 1]), -1);
            count += getSum(fenwickTree, Arrays.binarySearch(candidates, upper + sums[i - 1]));
            count -= getSum(fenwickTree, Arrays.binarySearch(candidates, lower + sums[i - 1] - 1));
        }
        return count;
    }

    private void updateFenwickTree(int[] fenwickTree, int index, int value) {
        for(int i = index; i < fenwickTree.length; i += i & (-i)) {
            fenwickTree[i] += value;
        }
    }

    private int getSum(int[] fenwickTree, int index) {
        int sum = 0;
        for(int i = index; i > 0; i -= i & (-i)) {
            sum += fenwickTree[i];
        }
        return sum;
    }
}