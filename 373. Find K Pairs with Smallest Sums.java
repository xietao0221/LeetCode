// https://discuss.leetcode.com/topic/52953/share-my-solution-which-beat-96-42
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(k <= 0 || nums1.length == 0 || nums2.length == 0) return new ArrayList<>();
        
        List<int[]> res = new ArrayList<>();
        PriorityQueue<Tuple> queue = new PriorityQueue<>();
        
        // input all combination of each element of nums1 and the first element of nums2
        for(int i = 0; i < nums1.length; i++) queue.offer(new Tuple(i, 0, nums1[i] + nums2[0]));
        
        // iterate k times
        int len = Math.min(k, nums1.length * nums2.length);
        for(int i = 0; i < len; i++) {
            Tuple curr = queue.poll();
            res.add(new int[]{nums1[curr.index1], nums2[curr.index2]});
            
            // we have inputed all elements of nums1, for the potential pair of next round
            // we need to increase the index of nums2 by 1
            if(curr.index2 < nums2.length - 1) {
                queue.offer(new Tuple(curr.index1, curr.index2 + 1, nums1[curr.index1] + nums2[curr.index2 + 1]));    
            }
        }
        return res;
    }

    class Tuple implements Comparable<Tuple> {
        int index1, index2, val;
        public Tuple(int index1, int index2, int val) {
            this.index1 = index1;
            this.index2 = index2;
            this.val = val;
        }

        public int compareTo(Tuple other) {
            return this.val - other.val;
        }
    }
}


// https://discuss.leetcode.com/topic/50527/java-10ms-solution-no-priority-queue
/*
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1.length == 0 || nums2.length == 0 || k == 0) return new ArrayList<>();
        
        // i is the index of array1, index2Array[i] is the index of array2
        // the default valud is 0, which means for each num in nums1, their pair number is all 0 in nums2
        int[] index2Array = new int[nums1.length];
        List<int[]> res = new ArrayList<>();
        
        while(k-- > 0) {
            int minSoFar = Integer.MAX_VALUE;
            int candIndex1 = -1;
            
            // iterate the nums1, and choose the smallest combination sum
            for(int i = 0; i < nums1.length; i++) {
                if(index2Array[i] < nums2.length && nums1[i] + nums2[index2Array[i]] <= minSoFar) {
                    candIndex1 = i;
                    minSoFar = nums1[i] + nums2[index2Array[i]];
                }
            }
            if(candIndex1 == -1) break;
            
            // (i, index2Array[i]) is used, so move one step forward in nums2 for i(index2Array[i]++)
            res.add(new int[]{nums1[candIndex1], nums2[index2Array[candIndex1]]});
            index2Array[candIndex1]++;
        }
        return res;
    }
}
*/