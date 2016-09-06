// https://discuss.leetcode.com/topic/32272/share-my-greedy-solution
public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int len1 = nums1.length, len2 = nums2.length;
        
        // i from max(0, k - len2): if num2.length = 2, k = 4, we should at least take 2 digits from num1
        // i <= k && i <= len1: we chould not choose more than k digits from num1; the max number could be
        // choosen from num1 is len1
        for(int i = Math.max(0, k - len2); i <= k && i <= len1; i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if(greater(candidate, 0, res, 0)) res = candidate;
        }
        return res;
    }
    
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int i = 0, j = 0;
        
        for(int index = 0; index < k; index++) {
            res[index] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return res;
    }
    
    // greater than or equals to
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while(i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        
        // j = num2.length: all digits in nums2 are checked, so nums1 and nums2 are the same
        // i < nums1.length && nums1[i] > nums2[j]: num1 and num2 are not fully checked but 'break', and at this time
        // the current digit of nums1 is greater than the one of nums2
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
    
    // very IMPORTANT func: return the largest number whose size is 'k' from the given 'nums'
    private int[] maxArray(int[] nums, int k) {
        int[] res = new int[k];
        int index = 0;      // the index of 'res'
        
        for(int i = 0; i < nums.length; i++) {
            // (1)  (n - i > k - index): have enough remaining digits to be compared
            // (2)  while(res[index - 1] < nums[i]): at this time, the (index-1) is the newest added digit
            //      compare this digit with the current num, if the res is smaller and you have enough 
            //      remaining digit to be compared, decrease the index(it ensures that the future added digit is 
            //      always larger than before and the size is k) until get the right and 'safe' position
            while((nums.length - i > k - index) && (index > 0 && res[index - 1] < nums[i])) index--;
            // now the index is the right position for the current digit
            if(index < k) res[index++] = nums[i];
        }
        return res;
    }
}