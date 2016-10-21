/*
大概就是一个数组
1,4,2,6....
每次调用一个函数，按照数组里面的数字的大小，返回相应的Index。
比如， 上面的例子就是
1/13 的概率返回0,
4/13的概率返回1.
* */
public class Solution {
    private int[] sum;
    private Random random = new Random();

    public Solution(int[] nums) {
        sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int getRandom() {
        int curr = random.nextInt(sum[sum.length - 1]);
        int left = 0, right = sum.length - 1, middle;
        while(left < right) {
            middle = left + (right - left) / 2;
            if(sum[middle] < curr) right = middle;
            else left = middle + 1;
        }
        return left;
    }
}