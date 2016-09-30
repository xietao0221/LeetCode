/*
given a list of bits, return the min length of bits used to differentiate them
*/
public class Solution {
    public int findMinBit(List<String> nums) {
        Set<Integer> set = new HashSet<>();
        return helper(nums, 0, set);
    }

    private int helper(List<String> nums, int begin, Set<Integer> set) {
        if (nums.size() == 1)
            return 0;
        int index = findDiff(nums, begin);
        set.add(index);
        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();
        for (String num : nums) {
            if (num.charAt(index) == '1')
                first.add(num);
            else
                second.add(num);
        }
        helper(first, index + 1, set);
        helper(second, index + 1, set);
        return set.size();
    }

    private int findDiff(List<String> nums, int begin) {
        int len = nums.get(0).length();
        for (int i = begin; i < len; i++) {
            for (int j = 1; j < nums.size(); j++) {
                if (nums.get(j).charAt(i) != nums.get(j-1).charAt(i))
                    return i;
            }
        }
        return -1;
    }
}