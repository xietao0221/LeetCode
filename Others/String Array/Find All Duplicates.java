public class Solution {
    public List<Integer> findDuplicate(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int pre = nums[i];
            // swap nums[i] with nums[nums[i]] to put each number to its right position
            while(nums[i] != i) {
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
                
                if(nums[i] == pre) break;
                pre = nums[i];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i) res.add(nums[i]);
        }
        return res;
    }
}