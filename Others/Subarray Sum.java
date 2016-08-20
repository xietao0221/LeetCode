/*
Given an integer array, find a subarray where the sum of numbers is zero. 
Your code should return the index of the first number and the index of the last number.

Example:
Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
*/
// similar to '325. Maximum Size Subarray Sum Equals k'
public class Solution {
	public List<int[]> subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		List<int[]> res = new HashMap<>();
		int sumSoFar = 0;
		map.put(sumSoFar, -1);

		for(int i = 0; i < nums.length; i++) {
			sumSoFar += nums[i];
			if(map.containsKey(sumSoFar - k)) {
				res.add(new int[]{map.get(sumSoFar - k) + 1, i});
			}
			map.put(sumSoFar, i);
		}
		return res;
	}
}