public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        
        int index = 0;
        while(index < nums.length) {
            if(nums[index] == index + 1 || nums[index] == nums[nums[index] - 1]) index++;
            else swap(nums, index, nums[index] - 1);
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) res.add(i + 1);
        }
        return res;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}