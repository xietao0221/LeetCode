// https://discuss.leetcode.com/topic/31702/36-ms-c-solution
public class Solution {
    public int shortestDistance(int[][] grid) {
        int[] res = new int[]{Integer.MAX_VALUE};
        int[][] distance = new int[grid.length][grid[0].length];
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int visitMark = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                // do bfs from each building
                if(grid[i][j] == 1) bfs(grid, distance, dirs, res, i, j, visitMark--);
            }
        }
        return res[0] == Integer.MAX_VALUE ? -1 : res[0];
    }
    
    public void bfs(int[][] grid, int[][] distance, int[][] dirs, int[] res, int row, int col, int visitMark) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        int dist = 0;
        res[0] = Integer.MAX_VALUE;
        
        while(!queue.isEmpty()) {
            // save the searching size of this level
            int size = queue.size();
            dist++;
            
            // bfs in the same level
            while(size-- > 0) {
                // pop out a current cell
                int[] curr = queue.poll();
                
                // for 4 directions
                for(int[] dir: dirs) {
                    int newRow = curr[0] + dir[0], newCol = curr[1] + dir[1];
                    
                    // use visitMark to filter out visited cells
                    // for the same building's same level, all non-visited cell has same visitMark
                    // for building 1, all valid cell has visitMark 0, after visiting each cell, make it -1
                    // for building 2, all valid cell has visitMark -1, after visiting each cell, make it -2
                    if(newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length 
                        && grid[newRow][newCol] == visitMark) {
                        
                        // put next searching cell into queue
                        queue.offer(new int[]{newRow, newCol});
                        
                        // this cell is visited, decrease it for the next building's search
                        grid[newRow][newCol]--;
                        
                        // save the distance between this cell and building
                        distance[newRow][newCol] += dist;
                        
                        // calculate the min distance
                        res[0] = Math.min(res[0], distance[newRow][newCol]);
                    }
                }
            }
        }
    }
}