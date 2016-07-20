public class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<rooms.length; i++) {
            for(int j=0; j<rooms[0].length; j++) {
                if(rooms[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }
        
        // four directions
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int i=0; i<dirs.length; i++) {
                // new position
                int row = curr[0] + dirs[i][0], col = curr[1] + dirs[i][1];
                if(row < 0 || col < 0 || row == rooms.length || col == rooms[0].length ||
                    rooms[row][col] != Integer.MAX_VALUE) continue;
                
                // because of BFS, this value is the smallest
                rooms[row][col] = rooms[curr[0]][curr[1]] + 1;
                // offer into queue as a new "gate"
                queue.offer(new int[]{row, col});
            }
        }
    }
}