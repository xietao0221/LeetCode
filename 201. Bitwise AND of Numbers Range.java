// if m != n, the last bit is 0, because there are at least one 1 and one 0
// so shift both m and n right until they are the same
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0) return 0;
        
        int count = 0;
        while(m != n) {
            m >>>= 1;
            n >>>= 1;
            count++;
        }
        return m << count;
    }
}