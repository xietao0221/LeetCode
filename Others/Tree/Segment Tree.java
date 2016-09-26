public class SegmentTree {
    private SegmentTreeNode root = null;

    public SegmentTree(int[] nums) {
        root = buildSegmentTree(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode buildSegmentTree(int[] nums, int start, int end) {
        if(start > end) return null;

        SegmentTreeNode curr = new SegmentTreeNode(start, end);

        if(start == end) {
            curr.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            curr.left = buildSegmentTree(nums, start, mid);
            curr.right = buildSegmentTree(nums, mid + 1, end);
            curr.sum = (curr.left != null ? curr.left.sum : 0) + (curr.right != null ? curr.right.sum : 0);
        }
        return curr;
    }

    public int getSum(int start, int end) {
        return getSumHelper(root, start, end);
    }

    private int getSumHelper(SegmentTreeNode root, int start, int end) {
        if(root.start == start && root.end == end) return root.sum;

        int mid = start + (end - start) / 2;
        if(end <= mid) {
            return getSumHelper(root.left, start, end);
        } else if(start > mid) {
            return getSumHelper(root.right, start, end);
        } else {
            return getSumHelper(root.left, start, mid) + getSumHelper(root.right, mid + 1, end);
        }
    }

    public void update(int pos, int val) {
        updateHelper(root, pos, val);
    }

    private void updateHelper(SegmentTreeNode root, int pos, int val) {
        if(root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if(pos <= mid) {
                updateHelper(root.left, pos, val);
            } else {
                updateHelper(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    class SegmentTreeNode {
        public int start, end, sum = 0;
        SegmentTreeNode left = null, right = null;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
