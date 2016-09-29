/*
http://www.csinterview.com/design-rand7-using-rand5/
use rand5() to get rand7()
Solution:
if you use base 5, 7 could be represented using two digits; so you generate 0 - 24 with equal possibilities.
*/
public class Solution {
    public int rand7() {
        int res = 0;
        while(true) {
            res = 5 * rand5() + rand5();
            if(res <= 20) break;
        }
        return res % 7;
    }
}