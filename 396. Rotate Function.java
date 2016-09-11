/*
F(0) = sum(i * A[i])
F(1) = F(0) + sum(A[i]) - 4 * A[3]
F(2) = F(1) + sum(A[i]) - 3 * A[2]
*/
public class Solution {
    public int maxRotateFunction(int[] A) {
        int sum = 0, F = 0;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            F += i * A[i];
        }
        
        int res = F;
        for(int i = 1; i < A.length; i++) {
            F += sum - A.length * A[A.length - i];
            res = Math.max(res, F);
        }
        return res;
    }
}