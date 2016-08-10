// https://discuss.leetcode.com/topic/32272/share-my-greedy-solution
public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int len1 = nums1.length, len2 = nums2.length;
        for(int i=Math.max(0, k-len2); i<=k && i<=len1; i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k-i), k);
            if(greater(candidate, 0, res, 0)) res = candidate;
        }
        return res;
    }
    
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for(int i=0, j=0, index=0; index<k; index++) {
            res[index] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return res;
    }
    
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while(i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
    
    private int[] maxArray(int[] nums, int k) {
        int[] res = new int[k];
        for(int i=0, j=0; i<nums.length; i++) {
            // (n-i > k-j): have enough remaining digits to be compared
            // while(res[j-1] < nums[i]): ensure you always find the largest digit so far
            while((nums.length - i > k - j) && (j > 0 && res[j-1] < nums[i])) j--;
            // put it to res only when you find the largest digit so far
            if(j < k) res[j++] = nums[i];
        }
        return res;
    }
}