/*
给了一个array，该array满足heap quality，
比如就是相当于把一个heap按照level order trasveral排成数组。
要求写一个函数找出里面的top K，不修改原数组，数组很大而K基本很小。

Solution

O(klogk)

*/
import java.util.*;

class Tests {
    public static void main(String... args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 200; ++i) {
            pq.offer((int)(Math.random() * 1000));
        }
        Object[] arr = pq.toArray();
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; ++i)
            nums[i] = (Integer)arr[i];
        System.out.println(Arrays.toString(nums));
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.topK(nums, 4)));

    }
}

public class Solution {
    public int[] topK(int[] nums, int k) {
        int n = nums.length;
        if (k >= n) return nums;
        int[] ans = new int[k];
        PriorityQueue<Tuple> candidates = new PriorityQueue<>(Collections.reverseOrder());
        Tuple tup = new Tuple(0, nums[0]);
        candidates.offer(tup);
        for (int i = 0; i < k && !candidates.isEmpty(); ++i) {
            tup = candidates.poll();
            ans[i] = tup.val;
            if (tup.left() < n) candidates.offer(new Tuple(tup.left(), nums[tup.left()]));
            if (tup.right() < n) candidates.offer(new Tuple(tup.right(), nums[tup.right()]));
        }
        return ans;
    }

    class Tuple implements Comparable<Tuple> {
        int idx, val;
        public Tuple(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
        public int left() { return idx * 2 + 1;}
        public int right() { return idx * 2 + 2;}
        @Override
        public int compareTo(Tuple that) {
            if (this.val < that.val) return -1;
            if (this.val > that.val) return +1;
            return 0;
        }
    }
}