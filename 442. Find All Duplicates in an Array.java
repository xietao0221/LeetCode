public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        int index = 0;
        
        while(index < nums.length) {
            if(nums[index] == index + 1) {
                index++;
            } else if(nums[index] == nums[nums[index] - 1]) {
                if(set.add(nums[index++])) res.add(nums[index - 1]);
            } else {
                swap(nums, index, nums[index] - 1);
            }
        }
        
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}