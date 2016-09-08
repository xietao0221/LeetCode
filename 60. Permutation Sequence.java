/*
n:      01  02  03  04
fac:    01  02  06  24
1234
1243
1324
1342
1423
1432
each group has 6, 2, 1 elements.
*/
public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int factorial = 1;
        
        for(int i = 1; i <= n; i++) {
            factorial *= i;
            list.add(i);
        }
        
        k--;        // not zero-based index
        for(int i = n; i >= 1; i--) {
            factorial /= i;
            sb.append(list.remove(k / factorial));
            k = k % factorial;
        }
        return sb.toString();
    }
}