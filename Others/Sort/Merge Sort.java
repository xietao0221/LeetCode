/**
 * Merge Sort
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 * Use Divide and Conquer Method: divide the array in half, sorts each of those halves, and then merge them back
 * together.
 * */
public class Solution {
    public void mergeSort(int[] nums) {
        mergeSortHelper(nums);
    }

    private int[] mergeSortHelper(int[] nums) {
        if(nums.length < 2) return nums;

        int mid = nums.length / 2;
        
        // left and right are new arrays which are sorted
        // copyOfRange(source array, start, end)
        int[] left = mergeSortHelper(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSortHelper(Arrays.copyOfRange(nums, mid, nums.length));

        // merge into original array
        for(int i = 0, j = 0; i < left.length || j < right.length;) {
            if(j == right.length || (i < left.length && left[i] <= right[j])) {
                nums[i + j] = left[i++];
            } else {
                nums[i + j] = right[j++];
            }
        }
        return nums;
    }
}

public class Solution {
    public void mergeSort(int[] nums) {
        mergeSortHelper(nums, 0, nums.length);
    }

    private void mergeSortHelper(int[] nums, int start, int end) {
        if(end - start <= 1) return;

        int mid = start + (end - start) / 2;

        // left and right are sorted already
        mergeSortHelper(nums, start, mid);
        mergeSortHelper(nums, mid, end);

        // create the cache array and its index
        int[] cache = new int[end - start];
        int r = 0;

        // merge into cache
        for(int i = start, j = mid; i < mid; i++) {
            while(j < end && nums[j] < nums[i]) cache[r++] = nums[j++];
            cache[r++] = nums[i];
        }

        // arraycopy(source array, source start, destination array, destination start, length)
        System.arraycopy(cache, 0, nums, start, end - start);
    }
}