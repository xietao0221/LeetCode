// Iterative Approach
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;                                 //avoid duplicate
            int left = i + 1, right = nums.length - 1, target = -nums[i];
            while(left < right) {
                if((nums[left] + nums[right]) == target) {
                    list.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while(left < right && nums[left] == nums[left + 1]) left++;         //avoid duplicate
                    while(left < right && nums[right] == nums[right - 1]) right--;      //avoid duplicate
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


// Recursive Approach
/*
public class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> tmpRes = new ArrayList<>();
    
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        threeSumHelper(nums, 0, 3, 0);
        return res;
    }
    
    private void threeSumHelper(int[] nums, int pos, int count, int sum) {
        if(pos == nums.length || count == 0) {
            if(sum == 0 && count == 0) res.add(new ArrayList<>(tmpRes));
            return;
        }
        
        for(int i = pos; i < nums.length && (sum + nums[i] <= 0); i++) {
            if(i > pos && nums[i] == nums[i-1]) continue;
            tmpRes.add(nums[i]);
            threeSumHelper(nums, i + 1, count - 1, sum + nums[i]);
            tmpRes.remove(tmpRes.size() - 1);
        }
    }
}
*/