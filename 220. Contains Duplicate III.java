public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || k <= 0 || t < 0) return false;
        
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<nums.length; i++) {
            if(i > k) set.remove(nums[i-k-1]);
            // floor() is the greatest number less than or equals to the given value
            // ceiling() is the least number greater than or equals to the given value
            Integer floor = set.floor(nums[i] + t), ceiling = set.ceiling(nums[i] - t);
            if((floor != null && (int)floor >= nums[i]) || (ceiling != null && (int)ceiling <= nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}