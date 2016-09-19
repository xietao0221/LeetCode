public class Solution {
    public boolean canCross(int[] stones) {
        if(stones[1] > 1) return false;
        if(stones.length <= 2) return true;
        return canCrossHelper(stones, 1, 1);
    }
    
    private boolean canCrossHelper(int[] stones, int pos, int k) {
        if(pos == stones.length - 1) return true;
        for(int i = pos + 1; i < stones.length; i++) {
            int jump = stones[i] - stones[pos];
            if(jump >= k - 1 && jump <= k + 1) {
                if(canCrossHelper(stones, i, jump)) return true;
            }
        }
        return false;
    }
}