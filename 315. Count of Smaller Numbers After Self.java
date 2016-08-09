// binary indexed tree
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) min = Math.min(min, nums[i]);;
        for(int i=0; i<nums.length; i++) {
            nums[i] = nums[i] - min + 1;
            max = Math.max(max, nums[i]);
        }
        List<Integer> res = new ArrayList<>();
        int[] fenwickTree = new int[max + 1];
        for(int i=nums.length-1; i>=0; i--) {
            res.add(0, getSum(fenwickTree, nums[i]-1));
            updateFenwickTree(fenwickTree, nums[i], 1);
        }
        return res;
    }
    
    private void updateFenwickTree(int[] fenwickTree, int index, int value) {
        while(index < fenwickTree.length) {
            fenwickTree[index] += value;
            index += (index & -index);
        }
    }
    
    private int getSum(int[] fenwickTree, int index) {
        int sum = 0;
        while(index > 0) {
            sum += fenwickTree[index];
            index -= (index & -index);
        }
        return sum;
    }
}

/*
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> visited = new ArrayList<>();
        Integer[] res = new Integer[nums.length];
        for(int i=nums.length-1; i>=0; i--) {
            int index = findIndex(visited, nums[i]);
            res[i] = index;
            visited.add(index, nums[i]);
        }
        return Arrays.asList(res);
    }
    
    // visited is the array list whose order is increasing
    private int findIndex(List<Integer> visited, int target) {
        if(visited.size() == 0) return 0;
        int start = 0, end = visited.size();
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(visited.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
*/