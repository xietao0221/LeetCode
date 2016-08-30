/*
sameColor[i] = diffColor[i-1]
if you want to paint a same color like the one on [i-1], the colors on previous two fences should be different,
so you choose diffColor[i-1]

diffColor[i]: (sameColor[i-1] + diffColor[i-1]) * (k - 1)
if you want to paint a color which is different with the one on [i-1], there are two conditions:
    (1) colors on the previous two fences are the same, at this time, the count is sameColor[i-1] * (k-1)
    (2) colors on the previous two fences are different, at this time, the count is diffColor[i-1] * (k-1)
*/
public class Solution {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0) return 0;
        if(n == 1) return k;
        
        // for the 2nd fence
        int sameColor = k;
        int diffColor = k * (k - 1);
        
        // for the 3rd through nth fence 
        for(int i = 3; i <= n; i++) {
            int tmp = diffColor;
            diffColor = (diffColor + sameColor) * (k - 1);
            sameColor = tmp;
        }
        return diffColor + sameColor;
    }
}