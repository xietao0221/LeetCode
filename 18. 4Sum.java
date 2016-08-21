public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length < 4) return list;
        Arrays.sort(nums);
        int len = nums.length;
        
        // anchor the first element
        for(int i = 0; i <= len - 4; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;                                 // avoid duplicate
            if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break;             // speed up
            if(nums[i] + nums[len-3] + nums[len-2] + nums[len-1] < target) continue;    // speed up
            
            // 3-sum
            for(int j = i + 1; j <= len - 3; j++) {
                if(j > i + 1 && nums[j] == nums[j-1]) continue;                         // avoid duplicate
                if(nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) break;           // speed up
                if(nums[i] + nums[j] + nums[len-2] + nums[len-1] < target) continue;    // speed up
                
                // two pointer
                int left = j + 1, right = len - 1, tmpTarget = target - nums[i] - nums[j];
                while(left < right) {
                    if(nums[left] + nums[right] == tmpTarget) {
                        list.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        while(left < right && nums[left] == nums[left+1]) left++;       // avoid duplicate
                        while(left < right && nums[right] == nums[right-1]) right--;    // avoid duplicate
                        left++;
                        right--;
                    } else if(nums[left] + nums[right] < tmpTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return list;
    }
}