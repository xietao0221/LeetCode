/*
Given a set of digits, find all combination which is smaller than the target.
Ex. nums = {1,3,5}, target = 300
return: 1, 3, 5, 11, 13, 15, 31, 33, 35, 51, 53, 55, 111, 113, 115...
*/
public class Solution {
    public List<Integer> findCombination(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        for(int num: nums) findCombinationHelper(nums, target, 0, num, res);
        return res;
    }

    private void findCombinationHelper(int[] nums, int target, int pos, int curr, List<Integer> res) {
        if(pos <= nums.length) {
            if(curr < target) res.add(curr);
            else return;
        }

        for(int i = 0; i < nums.length && curr < target; i++) {
            int next = curr * 10 + nums[i];
            findCombinationHelper(nums, target, i, next, res);
        }
    }
}