// https://discuss.leetcode.com/topic/59293/java-easiest-solution-o-logn-with-explanation
public class Solution {
    public int lastRemaining(int n) {
        boolean left = true;
        int head = 1, step = 1, remain = n;
        while(remain > 1) {
            if(left || remain % 2 == 1) head += step;
            step *= 2;
            remain /= 2;
            left = !left;
        }
        return head;
    }
}