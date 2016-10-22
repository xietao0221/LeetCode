// BST Solution
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();

        TreeNode root = null;
        Integer[] res = new Integer[nums.length];
        for(int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, res, i, 0);
        }
        return Arrays.asList(res);
    }

    private TreeNode insert(int num, TreeNode root, Integer[] res, int index, int preSum) {
        if(root == null) {
            // create new node no matter if it is duplicated
            res[index] = preSum;
            return new TreeNode(num);
        }
        
        if(num >= root.val) {
            // only change the preSum when going right,
            // 1) preSum is the count before root.parent
            // 2) root.segmentLeftCount is the count between root.parent and root
            // 3) num > root.val ? 1 : 0 is the count of root itself, 
            // if the statement of question is "smaller or equals to", it will be always 1
            root.right = insert(num, root.right, res, index, preSum + root.segmentLeftCount + (num > root.val ? 1 : 0));
        } else {
            // only change segmentLeftCount when going left
            // at this time, root.parent <= num < root, so increase root.segmentLeftCount
            root.segmentLeftCount++;
            root.left = insert(num, root.left, res, index, preSum);
        }
        return root;
    }

    class TreeNode {
        public int val, segmentLeftCount = 0;
        TreeNode left = null, right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        public String toString() {
            return val + "(" + segmentLeftCount + ")";
        }
    }
}

// Merge Sort Solution
/*
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        Pair[] arr = new Pair[nums.length];
        Integer[] smaller = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(i, nums[i]);
            smaller[i] = 0;
        }

        mergeSort(arr, smaller);

        return Arrays.asList(smaller);
    }

    private Pair[] mergeSort(Pair[] arr, Integer[] smaller) {
        if (arr.length <= 1) return arr;

        int mid = arr.length / 2;
        Pair[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid), smaller);
        Pair[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length), smaller);

        for (int i = 0, j = 0; i < left.length || j < right.length;) {
            if (j == right.length || (i < left.length && left[i].val <= right[j].val)) {
                arr[i + j] = left[i];
                // the count of number choosen from right is the count of smaller number on the right
                smaller[left[i].index] += j;
                i++;
            } else {
                arr[i + j] = right[j];
                j++;
            }
        }
        return arr;
    }

    class Pair {
        int index, val;

        public Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }

        public String toString() {
            return val + "(" + index + ")";
        }
    }
}
*/

// fenwick tree
/*
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        
        // clone the original array and sort it, store <value, position> into hash map
        Map<Integer, Integer> map = new HashMap<>();
        int[] sortedNum = nums.clone();
        Arrays.sort(sortedNum);
        for(int i = 0; i < nums.length; i++) map.put(sortedNum[i], i);
        
        // create fenwick tree whose length is one larger than the original array
        int[] fenwickTree = new int[nums.length + 1];
        List<Integer> res = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            res.add(0, getSum(fenwickTree, map.get(nums[i]) - 1));
            updateFenwickTree(fenwickTree, map.get(nums[i]), 1);
        }
        return res;
    }

    // the index is the index of original array
    private void updateFenwickTree(int[] fenwickTree, int index, int value) {
        // the index of fenwick tree is one larger than the index of original array
        for(int i = index + 1; i < fenwickTree.length; i += i & (-i)) {
            fenwickTree[i] += value;
        }
    }

    // the index is the index of original array
    private int getSum(int[] fenwickTree, int index) {
        int sum = 0;
        // the index of fenwick tree is one larger than the index of original array
        for(int i = index + 1; i > 0; i -= i & (-i)) {
            sum += fenwickTree[i];
        }
        return sum;
    }
}
*/

// Binary Search: find insert point
/*
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> visited = new ArrayList<>();
        Integer[] res = new Integer[nums.length];
        for(int i = nums.length - 1; i >= 0; i--) {
            // in the visited list, find the target's insert position, 
            // which is the count of number smaller than the target
            int index = findInsertPosition(visited, nums[i]);
            res[i] = index;
            visited.add(index, nums[i]);
        }
        return Arrays.asList(res);
    }
    
    // visited is the array list whose order is increasing
    private int findInsertPosition(List<Integer> visited, int target) {
        if(visited.size() == 0) return 0;
        int left = 0, right = visited.size() - 1, middle = 0;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if(visited.get(middle) < target) left = middle + 1;
            else right = middle - 1;
        }
        return left;
    }
}
*/