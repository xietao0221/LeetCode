public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        int[] bitMap = new int[32];
        for(int i = 0; i < 32; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(((1 << i) & nums[j]) != 0) bitMap[i]++;
            }
            result |= (bitMap[i] % 3) << i;
        }
        return result;
    }
}