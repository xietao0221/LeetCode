public class Solution {
    public boolean canCross(int[] stones) {
        // the most progressive arrange is [0, 1, 3, 6, 10, 15, 21, ...]
        // the right-most point is at most 0 + (1 + len - 1) * (len - 1) / 2
        if(stones == null || stones.length == 0 || stones[1] != 1 ||
                stones[stones.length - 1] > (stones.length * (stones.length - 1)) / 2) return false;

        // initialize the map and add the first step
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < stones.length; i++) map.put(stones[i], new HashSet<>());
        map.get(0).add(1);
        
        // don't need to explore the last stone
        for(int i = 0; i < stones.length - 1; i++) {
            // the stone the frog is standing at
            int anchor = stones[i];
            
            // from this stone, how long could the frog jump
            for(int jump: map.get(anchor)) {
                // the next stone the frog could standing at
                int next = anchor + jump;
                if(next == stones[stones.length - 1]) return true;
                
                // update the jumping stone's jumps
                if(map.containsKey(next)) {
                    if(jump - 1 > 0) map.get(next).add(jump - 1);
                    map.get(next).add(jump);
                    map.get(next).add(jump + 1);
                }
            }
        }
        return false;
    }
}

// Recursive Solution, result in TLE
/*
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
            
            if(jump < k - 1) {
                continue;
            } else if(jump <= k + 1) {
                if(canCrossHelper(stones, i, jump)) return true;
            } else {
                return false;
            }
        }
        
        return false;
    }
}
*/