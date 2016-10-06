public class Solution {
    public int[] findWrongNum(int[] nums) {
        Integer prev = Integer.MIN_VALUE, first = null, second = null;
        for(int num: nums) {
            // find the first mis-order num
            if(first == null && prev >= num) first = prev;
            // find the last mid-order num
            if(first != null && prev >= num) second = num;
            prev = num;
        }
        return new int[]{first, second};
    }
}