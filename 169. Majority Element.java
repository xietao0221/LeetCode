// Moore’s Voting Algorithm: http://www.geeksforgeeks.org/majority-element/
public class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0], count = 0;
        for(int num: nums) {
            if(count == 0) {
                candidate = num;
                count++;
            } else {
                if(num == candidate) count++;
                else count--;
            }
        }
        
        count = 0;
        for(int num: nums) {
            if(num == candidate) count++;
        }
        
        // in this question, don't need to do this check, but it is the standard process
        if(count > nums.length / 2) return candidate;
        else return -1;
    }
}