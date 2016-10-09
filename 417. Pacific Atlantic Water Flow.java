// DFS Solution
public class Solution {
    private List<int[]> res = new ArrayList<>();
    private int[][] visited;
    private int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return res;

        visited = new int[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            dfs(matrix, i, 0, Integer.MIN_VALUE, 1);
            dfs(matrix, i, matrix[0].length - 1, Integer.MIN_VALUE, 2);
        }
        
        for (int j = 0; j < matrix[0].length; j++) {
            dfs(matrix, 0, j, Integer.MIN_VALUE, 1);
            dfs(matrix, matrix.length - 1, j, Integer.MIN_VALUE, 2);
        }
        
        return res;
    }

    private void dfs(int[][] matrix, int row, int col, int preHeight, int mark) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length
                || matrix[row][col] < preHeight || (visited[row][col] & mark) == mark) return;
        
        visited[row][col] |= mark;
        if (visited[row][col] == 3) res.add(new int[]{row, col});
        
        for(int[] dir: dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            dfs(matrix, newRow, newCol, matrix[row][col], visited[row][col]);
        }
    }
}

// BFS Solution
/*
public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new ArrayList<>();
        
        Set<Position> pacific = findFloodArea(matrix, 0, 0, true);
        Set<Position> atlantic = findFloodArea(matrix, matrix.length - 1, matrix[0].length - 1, false);

        List<int[]> res = new ArrayList<>();
        Set<Position> smaller = pacific.size() < atlantic.size() ? pacific : atlantic;
        Set<Position> bigger = pacific.size() < atlantic.size() ? atlantic : pacific;
        for(Position pos : smaller) {
            if(bigger.contains(pos)) res.add(new int[]{pos.row, pos.col});
        }
        return res;
    }

    private Set<Position> findFloodArea(int[][] matrix, int row, int col, boolean direction) {
        Set<Position> res = new HashSet<>();
        Queue<Position> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for(int j = 0; j < matrix[0].length; j++) {
            Position tmp = new Position(row, j);
            queue.add(tmp);
            res.add(tmp);
            visited[tmp.row][tmp.col] = true;
        }

        int start = direction ? 1 : 0, end = direction ? matrix.length : matrix.length - 1;
        for(int i = start; i < end; i++) {
            Position tmp = new Position(i, col);
            queue.add(tmp);
            res.add(tmp);
            visited[tmp.row][tmp.col] = true;
        }

        while(!queue.isEmpty()) {
            Position curr = queue.poll();
            for(int[] dir: dirs) {
                int newRow = curr.row + dir[0], newCol = curr.col + dir[1];
                if(newRow >= 0 && newCol >= 0 && newRow < matrix.length
                        && newCol < matrix[0].length && !visited[newRow][newCol]) {
                    Position newPos = new Position(newRow, newCol);
                    if(matrix[newRow][newCol] >= matrix[curr.row][curr.col]) {
                        queue.add(newPos);
                        res.add(newPos);
                        visited[newPos.row][newPos.col] = true;
                    }
                }
            }
        }
        return res;
    }

    class Position {
        int row, col;
        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public boolean equals(Object other) {
            Position o = (Position)other;
            return this.row == o.row && this.col == o.col;
        }

        public int hashCode() {
            return 31 * row + col;
        }

        public String toString() {
            return "(" + row + "," + col + ")";
        }
    }
}
*/