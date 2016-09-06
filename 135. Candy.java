public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        
        int[] nums = new int[ratings.length];
        nums[0] = 1;
        int res = 1;
        
        // left -> right: ensure the child with higher ranking has higher amount than its left one
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1]) nums[i] = nums[i - 1] + 1;
            else nums[i] = 1;
            
            res += nums[i];
        }
        
        // right -> left: ensure the child with higher ranking has higher amount than its right one
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1] && nums[i] <= nums[i + 1]) {
                res += (nums[i + 1] + 1) - nums[i];
                nums[i] = nums[i + 1] + 1;
            }
        }
        return res;
    }
}