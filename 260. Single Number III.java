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