// Moore’s Voting Algorithm: http://www.geeksforgeeks.org/majority-element/
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        
        int candidate1 = nums[0], candidate2 = nums[0], count1 = 0, count2 = 0;
        for(int num: nums) {
            if(candidate1 == num) {
                count1++;
            } else if(candidate2 == num) {
                count2++;
            } else if(count1 == 0) {
                count1++;
                candidate1 = num;
            } else if(count2 == 0) {
                count2++;
                candidate2 = num;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for(int num: nums) {
            if(num == candidate1) count1++;
            else if(num == candidate2) count2++;
        }
        
        if(count1 > nums.length / 3) res.add(candidate1);
        if(count2 > nums.length / 3) res.add(candidate2);
        return res;
    }
}