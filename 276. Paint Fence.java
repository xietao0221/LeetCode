public class Solution {
    // S(n) = D(n-1)
    // D(n) = (k-1) * (D(n-1) + S(n-1))
    public int numWays(int n, int k) {
        if(n == 0 || k==0) return 0;
        if(n == 1) return k;
        int sameColor = k;
        int diffColor = k * (k-1);
        for(int i=2; i<n; i++) {
            int tmp = diffColor;
            diffColor = (diffColor + sameColor) * (k-1);
            sameColor = tmp;
        }
        return diffColor + sameColor;
    }
}