/**
 * Quick Sort
 * Time Complexity: O(nlogn)
 * Space Complexity: O(logn)
 * Pick a random element and partition the array, such that all numbers that are less than the partitioning element
 * come before all elements that are greater than it.
 * */
public class Solution {
    public void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private void quickSortHelper(int[] array, int left, int right) {
        int index = partition(array, left, right);
        if(left < index - 1) quickSortHelper(array, left, index - 1);
        if(index < right) quickSortHelper(array, index, right);
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[(left + right) / 2];
        while(left <= right) {
            while(array[left] < pivot) left++;
            while(array[right] > pivot) right--;
            if(left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        return left;            //the first element which is >= pivot
    }
}