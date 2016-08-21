public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int left = 0, right = nums.length - 1, index = a >= 0 ? nums.length - 1 : 0;
        while(left <= right) {
            int tmpLeft = calculate(nums[left], a, b, c), tmpRight = calculate(nums[right], a, b, c);
            if(a >= 0) {
                if(tmpLeft >= tmpRight) {
                    res[index--] = tmpLeft;
                    left++;
                } else {
                    res[index--] = tmpRight;
                    right--;
                }
            } else {
                if(tmpLeft <= tmpRight) {
                    res[index++] = tmpLeft;
                    left++;
                } else {
                    res[index++] = tmpRight;
                    right--;
                }
            }
        }
        return res;
    }
    
    private int calculate(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}