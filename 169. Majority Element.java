// Moore’s Voting Algorithm: http://www.geeksforgeeks.org/majority-element/
public class Solution {
    public int majorityElement(int[] nums) {
        int candidateIndex = 0, count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(count == 0) {
                candidateIndex = i;
                count++;
            } else {
                if(nums[i] == nums[candidateIndex]) count++;
                else count--;
            }
        }
        
        // based on the statement that the majority element is always exist
        // so we do not need to use one more loop to check if this candidate
        // is valid or not.
        return nums[candidateIndex];
    }
}