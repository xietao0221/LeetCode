// allow the contiguous ones are the same
public class Solution {
    public void wiggleSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            // don't need to worry about the current change affect the previous ones
            // Ex. nums[0] < nums[1] < nums[2], we swap nums[1] and nums[2], nums[2] must larger than nums[1], no hurt
            // Ex. nums[1] > nums[2] > nums[3], we swap nums[2] and nums[3], nums[3] must smaller than nums[1], no hurt
            if((i % 2 == 1 && nums[i] < nums[i + 1]) || (i % 2 == 0 && nums[i] > nums[i + 1])) {
                int tmp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = tmp;
            }
        }
    }
}