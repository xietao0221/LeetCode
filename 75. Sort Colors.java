// one pass solution
public class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, second = nums.length - 1;
        for(int i = 0; i <= second; i++) {
            while(nums[i] == 2 && i < second) swap(nums, i, second--);
            while(nums[i] == 0 && i > zero) swap(nums, i, zero++);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// two pass solution
/*
public class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int num: nums) count[num]++;
        int start = 0;
        while(start < nums.length) {
            for(int i=0; i<3; i++) {
                while(count[i]-- > 0) nums[start++] = i;
            }
        }
    }
}
*/