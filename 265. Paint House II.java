// use two vars to save the first and second min
public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;

        // currMin1 is the index of first min
        // currMin2 is the index of second min
        int currMin1 = 0, currMin2 = 0;

        for(int i=0; i<costs.length; i++) {
            int prevMin1 = currMin1, prevMin2 = currMin2;
            currMin1 = -1;
            currMin2 = -1;
            for (int j = 0; j < costs[0].length; j++) {
                if(i > 0) {
                    if(j != prevMin1) costs[i][j] += costs[i-1][prevMin1];
                    else costs[i][j] += costs[i-1][prevMin2];
                }

                if(currMin1 < 0 || costs[i][j] < costs[i][currMin1]) {
                    currMin2 = currMin1;
                    currMin1 = j;
                } else if(currMin2 < 0 || costs[i][j] < costs[i][currMin2]) {
                    currMin2 = j;
                }
            }
        }
        return costs[costs.length-1][currMin1];
    }
}