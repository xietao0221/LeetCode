/*
1 - 9:      [1, 1 + 9 * 1)
10 - 99:    [10, 10 + 90 * 2)
100 - 999:  [190, 190 + 900 * 3)
*/
public class Solution {
    public int findNthDigit(int n) {
        int len = 1, start = 1;
        long count = 9;
        
        // find which group
        while(n > len * count) {
            n -= len * count;
            len++;
            start *= 10;
            count *= 10;
        }
        
        // find the specific number
        n--;            // not zero based
        int target = start + n / len;
        String s = Integer.toString(target);
        return s.charAt(n % len) - '0';
    }
}