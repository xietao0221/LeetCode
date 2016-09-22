// https://leetcode.com/discuss/110478/math-solution-java-solution
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z) return false;
        if(z == x || z == y || z == x + y) return true;
        
        return z % GCD(x, y) == 0;
    }
    
    private int GCD(int a, int b) {
        if(b == 0) return a;
        return GCD(b, a % b);
    }
}