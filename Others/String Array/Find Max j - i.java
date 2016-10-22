// Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
// http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
public class Solution {
    public int findMaxGap(int[] nums) {
        int[] leftMin = new int[nums.length], rightMax = new int[nums.length];

        leftMin[0] = nums[0];
        for(int i = 1; i < nums.length; i++) leftMin[i] = Math.min(leftMin[i - 1], nums[i]);

        rightMax[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--) rightMax[i] = Math.max(rightMax[i + 1], nums[i]);

        int left = 0, right = 0, res = -1;
        while(left < nums.length && right < nums.length) {
            if(leftMin[left] < rightMax[right]) {
                res = Math.max(res, right - left);
                right++;
            } else {
                left++;
            }
        }
        return res;
    }
}