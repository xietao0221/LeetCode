public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int res = 0, sumSoFar = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            sumSoFar += nums[i];
            if(sumSoFar == k) res = Math.max(res, i + 1);
            if(map.containsKey(sumSoFar - k)) res = Math.max(res, i - map.get(sumSoFar - k));
            if(!map.containsKey(sumSoFar)) map.put(sumSoFar, i);
        }
        return res;
    }
}