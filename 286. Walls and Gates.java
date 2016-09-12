public class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        // put all gates into queue
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }
        
        // move one step from each cell in the queue, which results in the optimal distance
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int[] dir: dirs) {
                int newRow = curr[0] + dir[0], newCol = curr[1] + dir[1];
                if(newRow < 0 || newCol < 0 || newRow == rooms.length || newCol == rooms[0].length ||
                    rooms[newRow][newCol] != Integer.MAX_VALUE) continue;
                
                rooms[newRow][newCol] = rooms[curr[0]][curr[1]] + 1;
                queue.offer(new int[]{newRow, newCol});
            }
        }
    }
}