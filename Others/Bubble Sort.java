/**
 * Bubble Sort
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * We start at the beginning of the array and swap the first two elements if the first is greater than the second.
 * Then, we go to the next pair, and so on, continuously making swaps of the array until it is sorted.
 * Each loop, the greatest element is swapped to the right most of array.
 * */
public class Solution {
    public void bubbleSort(int[] nums) {
        if(nums == null || nums.length <= 1) return;

        boolean swapped = true;
        int j = 0;
        while(swapped) {        //if swapping occurs in the previous iteration, continue iterating.
            swapped = false;
            for(int i = 1; i < nums.length - j; i++) {
                if(nums[i - 1] > nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                    swapped = true;
                }
            }
            j++;            //there are j top sorted greatest element on the right of array.
        }
    }
}
