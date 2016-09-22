// hash set solution
public class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n: nums) {
            if(set.contains(n)) set.remove(n);
            else set.add(n);
        }
        
        Iterator iter = set.iterator();
        return new int[]{(int)iter.next(), (int)iter.next()};
    }
}

// bit manipulation solution
// https://discuss.leetcode.com/topic/21605/accepted-c-java-o-n-time-o-1-space-easy-solution-with-detail-explanations
/*
public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int num: nums) {
            diff ^= num;
        }
        
        // get the last set bit
        diff &= -diff;
        
        //
        int[] res = new int[2];
        for(int num: nums) {
            if((num & diff) == 0) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }
}
*/