// https://discuss.leetcode.com/category/397/shortest-distance-from-all-buildings
public class Solution {
    public int shortestDistance(int[][] grid) {
        int[] res = new int[]{Integer.MAX_VALUE};
        int[][] distance = new int[grid.length][grid[0].length];
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int index = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) bfs(grid, distance, dirs, res, i, j, index--);
            }
        }
        return res[0] == Integer.MAX_VALUE ? -1 : res[0];
    }
    
    public void bfs(int[][] grid, int[][] distance, int[][] dirs, int[] res, int row, int col, int index) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        int level = 0;
        res[0] = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while(size-- > 0) {
                int[] curr = queue.poll();
                for(int[] dir: dirs) {
                    int newRow = curr[0] + dir[0], newCol = curr[1] + dir[1];
                    // use index to filter out visited cells
                    //  I walk only onto the cells that were reachable from all previous buildings. 
                    // From the first building I only walk onto cells where grid is 0, and make them -1. 
                    // From the second building I only walk onto cells where grid is -1, and I make them -2.
                    if(newRow >= 0 && newCol >= 0 && newRow < grid.length &&
                            newCol < grid[0].length && grid[newRow][newCol] == index) {
                        queue.offer(new int[]{newRow, newCol});
                        grid[newRow][newCol]--;                 // visited
                        distance[newRow][newCol] += level;      // core
                        res[0] = Math.min(res[0], distance[newRow][newCol]);
                    }
                }
            }
        }
    }
}