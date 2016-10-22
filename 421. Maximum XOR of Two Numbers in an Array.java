public class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask = 0, res = 0;
        for(int i = 31; i >= 0; i--) {
            mask |= 1 << i;
            
            // extract the ith bit, and put it into set
            Set<Integer> set = new HashSet<>();
            for(int num: nums) set.add(num & mask);

            // the ith bit of tmpRes is 1: 1 ^ 0 = 1, 1 ^ 1 = 0
            // so if set has a and a ^ tmpRes, this bit i is valid, should be in the final result
            int tmpRes = res | (1 << i);
            for(int prefix: set) {
                if(set.contains(prefix ^ tmpRes)) {
                    res = tmpRes;
                    break;
                }
            }
        }
        return res;
    }
}