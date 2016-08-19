// two pointers
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] tmpRes = new int[nums1.length >= nums2.length ? nums1.length : nums2.length];
        int index1 = 0, index2 = 0, index = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(index1 < nums1.length && index2 < nums2.length) {
            if(nums1[index1] == nums2[index2]) {
                tmpRes[index++] = nums1[index1];
                index1++;
                index2++;    
            } else if(nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        
        int[] res = new int[index];
        for(int i = 0; i < res.length; i++) res[i] = tmpRes[i];
        return res;
    }
}