public class NumArray {
    int[] original, fenwickTree;
    public NumArray(int[] nums) {
        original = new int[nums.length];
        fenwickTree = new int[nums.length + 1];
        for(int i=0; i<nums.length; i++) {
            update(i, nums[i]);
        }
    }

    void update(int index, int val) {
        int diff = val - original[index];
        original[index] = val;
        for(int i=index+1; i<fenwickTree.length; i+=i&(-i)) {
            fenwickTree[i] += diff;
        }
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i-1);
    }
    
    private int getSum(int index) {
        int sum = 0;
        for(int i=index+1; i>0; i-=i&(-i)) {
            sum += fenwickTree[i];
        }
        return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);

// Segment Tree
/*
public class NumArray {
    private SegmentTreeNode root;

    public NumArray(int[] nums) {
        root = buildSegmentTree(nums, 0, nums.length-1);
    }

    void update(int i, int val) {
        updateHelper(root, i, val);
    }

    private void updateHelper(SegmentTreeNode root, int position, int val) {
        if(root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if(position <= mid) {
                updateHelper(root.left, position, val);
            } else {
                updateHelper(root.right, position, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }

    }

    public int sumRange(int i, int j) {
        return sumRangeHelper(root, i, j);
    }

    private int sumRangeHelper(SegmentTreeNode root, int start, int end) {
        if(root.start == start && root.end == end) return root.sum;
        int mid = root.start + (root.end - root.start) / 2;
        if(end <= mid) {
            return sumRangeHelper(root.left, start, end);
        } else if(start > mid) {
            return sumRangeHelper(root.right, start, end);
        } else {
            return sumRangeHelper(root.left, start, mid) + sumRangeHelper(root.right, mid+1, end);
        }
    }

    private SegmentTreeNode buildSegmentTree(int[] nums, int start, int end) {
        if(start > end) return null;
        SegmentTreeNode res = new SegmentTreeNode(start, end);
        if(start == end) {
            res.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            res.left = buildSegmentTree(nums, start, mid);
            res.right = buildSegmentTree(nums, mid+1, end);
            res.sum = res.left.sum + res.right.sum;
        }
        return res;
    }

    class SegmentTreeNode {
        int start, end, sum;
        SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
            this.left = null;
            this.right = null;
        }
    }
}
*/