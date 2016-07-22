public class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);
        for(int num: nums) {
            int target = num, count = 1;
            while(set.contains(--target)) {
                count++;
                set.remove(target);
            }
            
            target = num;
            while(set.contains(++target)) {
                count++;
                set.remove(target);
            }
            res = Math.max(res, count);
        }
        return res;
    }
}