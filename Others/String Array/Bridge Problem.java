// http://blog.sina.com.cn/s/blog_77dd9d490102vwf3.html
/*
n = 2: a2
n = 3: a1 + a2 + a3
n = 4:
    a1, a4      ->  a4
    a1          <-  a1
    a1, a3      ->  a3
    a1          <-  a1
    a1, a2      ->  a2
    ==> a1 + a1 + (a2) + a3 + a4

    a1, a2      ->  a2
    a1          <-  a1
    a3, a4      ->  a4
    a2          ->  a2
    a1, a2      ->  a2
    ==> a1 + a2 + a2 + (a2) + a4
*/
public class Solution {
    public int bridgeProb(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        int i;
        for(i = nums.length - 1; i > 2; i -= 2) {
            sum += Math.min(nums[0] + nums[0] + nums[i - 1] + nums[i], nums[0] + nums[1] + nums[1] + nums[i]);
        }

        if(i == 2) sum += nums[0] + nums[1] + nums[2];
        else if(i == 1) sum += nums[1];
        else sum = nums[0];

        return sum;
    }
}