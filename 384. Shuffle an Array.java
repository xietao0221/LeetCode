public class Solution {
    private int[] nums;
    private java.util.Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new java.util.Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] newNums = nums.clone();
        for(int j=1; j<newNums.length; j++) {
            int i = random.nextInt(j + 1);
            int tmp = newNums[j];
            newNums[j] = newNums[i];
            newNums[i] = tmp;
        }
        return newNums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */