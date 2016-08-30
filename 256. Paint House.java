// the same as '265. Paint House II'
public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        
        int currMin1 = -1, currMin2 = -1;
        
        // for each house
        for(int i = 0; i < costs.length; i++) {
            int prevMin1 = currMin1, prevMin2 = currMin2;
            currMin1 = -1;
            currMin2 = -1;
            
            // for each choice of color
            for(int j = 0; j < costs[0].length; j++) {
                // choose freely when you paint the 1st house, not previous color restriction
                if(i > 0) {
                    // avoid same color as before
                    if(j != prevMin1) costs[i][j] += costs[i - 1][prevMin1];
                    else costs[i][j] += costs[i - 1][prevMin2];
                }
                
                // get the first and second min cost value for the next round
                if(currMin1 < 0 || costs[i][j] < costs[i][currMin1]) {
                    currMin2 = currMin1;
                    currMin1 = j;
                } else if(currMin2 < 0 || costs[i][j] < costs[i][currMin2]) {
                    currMin2 = j;
                }
            }
        }
        return costs[costs.length - 1][currMin1];
    }
}

// hard code
/*
public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        
        for(int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        return Math.min(Math.min(costs[costs.length - 1][0], costs[costs.length - 1][1]), costs[costs.length - 1][2]);
    }
}
*/