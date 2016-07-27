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