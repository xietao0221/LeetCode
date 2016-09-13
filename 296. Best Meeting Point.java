// https://discuss.leetcode.com/topic/27762/java-2ms-python-40ms-two-pointers-solution-no-median-no-sort-with-explanation
// transform 2D grid to 1D array, and calculate the mean point
public class Solution {
    public int minTotalDistance(int[][] grid) {
        int[] rowSum = new int[grid[0].length], colSum = new int[grid.length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                rowSum[j] += grid[i][j];
                colSum[i] += grid[i][j];
            }  
        }
        return minDistance1D(rowSum) + minDistance1D(colSum);
    }
    
    public int minDistance1D(int[] array) {
        int i = -1, j = array.length;
        int left = 0, right = 0, res = 0;
        while(i < j) {
            if(left < right) {
                res += left;
                left += array[++i];
            } else {
                res += right;
                right += array[--j];
            }
        }
        return res;
    }
}

// BFS: result in TLE
/*
public class Solution {
    public int minTotalDistance(int[][] grid) {
        int[][] distance = new int[grid.length][grid[0].length];
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int visitMark = 0;
    
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) bfs(grid, distance, dirs, i, j);
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < distance.length; i++) {
            for(int j = 0; j < distance[0].length; j++) {
                res = Math.min(res, distance[i][j]);
            }
        }
        return res;
    }
    
    public void bfs(int[][] grid, int[][] distance, int[][] dirs, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int dist = 0;
        
        queue.offer(new int[]{row, col});
        visited[row][col] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            dist++;
            
            while(size-- > 0) {
                int[] curr = queue.poll();
                visited[curr[0]][curr[1]] = true;
                for(int[] dir: dirs) {
                    int newRow = curr[0] + dir[0], newCol = curr[1] + dir[1];
                    if(newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length 
                        && !visited[newRow][newCol]) {
                        queue.offer(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                        distance[newRow][newCol] += dist;
                    }
                }
            }
        }
    }
}
*/