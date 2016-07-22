// https://discuss.leetcode.com/topic/50527/java-10ms-solution-no-priority-queue
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        int[] index1Array = new int[nums1.length];
        while(k-- > 0) {
            int minSoFar = Integer.MAX_VALUE;
            int tmpIndex = -1;
            for(int i=0; i<nums1.length; i++) {
                if(index1Array[i] >= nums2.length) continue;
                if(nums1[i] + nums2[index1Array[i]] <= minSoFar) {
                    tmpIndex = i;
                    minSoFar = nums1[i] + nums2[index1Array[i]];
                }
            }
            if(tmpIndex == -1) break;
            res.add(new int[]{nums1[tmpIndex], nums2[index1Array[tmpIndex]]});
            index1Array[tmpIndex]++;
        }
        return res;
    }
}