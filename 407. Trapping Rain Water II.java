// save all bounder cells first and make them visited, so during popping out from queue, these cells cannot be explored.
// and then only check inner cells, if there is a inner pit, record the difference, and save the new cell into queue.
// notes that the new cell's height is the new height if water is poured.
public class Solution {
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) return 0;
        
        // save all bounder cells into queue
        PriorityQueue<Cell> queue = new PriorityQueue<>();
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        for(int i = 0; i < heightMap.length; i++) {
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            visited[i][0] = true;
            queue.offer(new Cell(i, heightMap[0].length - 1, heightMap[i][heightMap[0].length - 1]));
            visited[i][heightMap[0].length - 1] = true;
        }
        for(int j = 1; j < heightMap[0].length - 1; j++) {
            queue.offer(new Cell(0, j, heightMap[0][j]));
            visited[0][j] = true;
            queue.offer(new Cell(heightMap.length - 1, j, heightMap[heightMap.length - 1][j]));
            visited[heightMap.length - 1][j] = true;
        }
        
        // pop out cells in ascending order based on their height
        int res = 0;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()) {
            Cell curr = queue.poll();
            for(int[] dir: dirs) {
                int row = curr.row + dir[0], col = curr.col + dir[1];
                if(row >= 0 && col >= 0 && row < heightMap.length &&
                        col < heightMap[0].length && !visited[row][col]) {
                    visited[row][col] = true;
                    
                    // if the curr cell is higher, record the difference
                    res += Math.max(0, curr.height - heightMap[row][col]);
                    
                    // the target cell's height is max(curr.height, self.height) because water is saved
                    queue.offer(new Cell(row, col, Math.max(curr.height, heightMap[row][col])));
                }
            }
        }
        return res;
    }
    
    class Cell implements Comparable<Cell> {
        public int row, col, height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        public int compareTo(Cell o) {
            return this.height - o.height;
        }
    }
}