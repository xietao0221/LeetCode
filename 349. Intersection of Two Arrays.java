// two pointer
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] tmpRes = new int[nums1.length >= nums2.length ? nums2.length : nums1.length];
        int index1 = 0, index2 = 0, index = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        while(index1 < nums1.length && index2 < nums2.length) {
            if(nums1[index1] == nums2[index2]) {
                if(index == 0 || nums1[index1] != tmpRes[index - 1]) tmpRes[index++] = nums1[index1];   // avoid duplicate
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

// hash set
/*
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>(), res = new HashSet<>();
        for(int num: nums1) set.add(num);
        for(int num: nums2) {
            if(set.contains(num)) res.add(num);
        }
        
        int[] resArray = new int[res.size()];
        int index = 0;
        for(int num: res) resArray[index++] = num;
        return resArray;
    }
}
*/