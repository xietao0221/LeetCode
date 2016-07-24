public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(i > k) {
                set.remove(nums[i-k-1]);
            }
            if(!set.add(nums[i])) {     //add(): if the set already contains this element, return false
                return true;
            }
        }
        return false;
    }
}