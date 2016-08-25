// Merge Sort: figure it out later
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        
        // List<Integer> res = new ArrayList<>();
        Pair[] arr = new Pair[nums.length];
        int[] smaller = new int[nums.length];
        // Arrays.fill(smaller, 0);
        
        for(int i = 0; i < nums.length; i++) arr[i] = new Pair(i, nums[i]);
        mergeSort(arr, smaller);
        // res.addAll(Arrays.asList(smaller));
        return new ArrayList<>(Arrays.asList(smaller));
    }
    
    private Pair[] mergeSort(Pair[] arr, int[] smaller) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        Pair[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid), smaller);
        Pair[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length), smaller);
        for(int i = 0, j = 0; i < left.length || j < right.length;) {
            if(j == right.length || i < left.length && left[i].val <= right[j].val) {
                arr[i + j] = left[i];
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
    }
}

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

// binary indexed tree - length could be too long, not a good idea
/*
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();

        // find min value and minus min by each elements, plus 1 to avoid 0 element
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) min = Math.min(min, nums[i]);;
        for(int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - min + 1;
            max = Math.max(max, nums[i]);
        }

        List<Integer> res = new ArrayList<>();
        int[] fenwickTree = new int[max + 1];
        for(int i = nums.length - 1; i >= 0; i--) {
            // the index of nums[i] is nums[i] - 1
            // we need to find the sum (-INF, nums[i] - 1], so the index is nums[i] - 2
            res.add(0, getSum(fenwickTree, nums[i] - 2));
            
            // after searching, we need to update the fenwick tree for the next round
            // the new added number is nums[i], but its index of original is nums[i] - 1
            updateFenwickTree(fenwickTree, nums[i] - 1, 1);
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