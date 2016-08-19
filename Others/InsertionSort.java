/**
 * Insertion Sort
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * Pick a key, compare it with elements before it one by one until find the correct position.
 * */
public class InsertionSort {
    public void insertionSort(int[] nums) {
        int i, j;
        for(i = 1; i < nums.length; i++) {
            int key = nums[i];
            for(j = i - 1; j >= 0 && key < nums[j]; j--) {
                nums[j+1] = nums[j];
            }
            nums[j+1] = key;
        }
    }
}
