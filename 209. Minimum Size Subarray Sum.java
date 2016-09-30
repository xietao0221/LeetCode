// sliding Window Approach O(n)
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int left = 0, right = 0, localSum = 0, res = Integer.MAX_VALUE;
        while(right < nums.length) {
            localSum += nums[right++];
            while(localSum >= s) {
                res = Math.min(res, right - left);
                localSum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

// TreeMap solution, result in TLE
/*
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int localSum = 0, res = Integer.MAX_VALUE;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            localSum += nums[i];
            
            // floor <= localSum - s ==> localSum - floor >= s
            Integer floor = map.floorKey(localSum - s);
            if(floor != null) res = Math.min(res, i - map.get(floor));
            
            map.put(localSum, i);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
*/

// Binary Search Approach O(nlogn)
/*
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for(int i = 1; i < sums.length; i++) sums[i] = sums[i-1] + nums[i-1];
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < sums.length; i++) {
            // i is the starting point, we are going to search the ending point, the target is sums[i] + s
            // end is the inserting point for sums[i] + s, which means sums[end] >= sums[i] + s
            // Ex. sums = [0,2,5,6,8,12,15], and the target is 7, end is 4, and 8(index 4) >= 7, meet the requirement
            int end = binarySearch(sums, sums[i] + s, i + 1, sums.length - 1);
            if(end == sums.length) break;
            res = Math.min(res, end - i);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    
    // it is '35. search insert position'
    private int binarySearch(int[] nums, int target, int left, int right) {
        while(left <= right) {
            int middle = left + (right - left) / 2;
            if(nums[middle] < target) left = middle + 1;
            else right = middle - 1;
        }
        return left;
    }
}
*/