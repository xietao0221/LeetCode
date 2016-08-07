// https://discuss.leetcode.com/topic/52953/share-my-solution-which-beat-96-42
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if(k <= 0 || nums1.length == 0 || nums2.length == 0) return res;
        PriorityQueue<Tuple> queue = new PriorityQueue<>();
        // input all combination of each element of nums1 and the first element of nums2
        for(int i=0; i<nums1.length; i++) queue.offer(new Tuple(i, 0, nums1[i]+nums2[0]));
        // iterate k times
        for(int i=0; i<Math.min(k, nums1.length*nums2.length); i++) {
            Tuple curr = queue.poll();
            res.add(new int[]{nums1[curr.index1], nums2[curr.index2]});
            if(curr.index2 == nums2.length - 1) continue;
            // we have inputed all elements of nums1, so we need to increase the index of nums2 by 1
            queue.offer(new Tuple(curr.index1, curr.index2+1, nums1[curr.index1]+nums2[curr.index2+1]));
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
*/