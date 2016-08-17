public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, n);
        int middle = (n - 1) / 2;
        for(int i = 0; i < n / 2; i++) {
            nums[i * 2] = temp[middle - i];
            nums[i * 2 + 1] = temp[n - 1 - i];
        }
        if(n % 2 == 1) nums[n - 1] = temp[0];
    }
}
