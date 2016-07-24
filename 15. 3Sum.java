public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;                               //avoid duplicate
            int left = i+1, right = nums.length-1, target = -nums[i];
            while(left < right) {
                if((nums[left] + nums[right]) == target) {
                    list.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while(left < right && nums[left] == nums[left+1]) left++;       //avoid duplicate
                    while(left < right && nums[right] == nums[right-1]) right--;    //avoid duplicate
                    left++;
                    right--;
                } else if(nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }
}