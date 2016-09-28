/*
Problem Statement
Suppose you have a 2-D grid. Each point is either land or water. There is also a start point and a goal.

There are now keys that open up doors. Each key corresponds to one door.

Implement a function that returns the shortest path from the start to the goal using land tiles, keys and open doors.

Data Representation
The map will be passed as an array of strings.

A map can have the following tiles.

0 = Water
1 = Land
2 = Start
3 = Goal

uppercase = door
lowercase = key

Example Maps (keys at each step are not required)
`No doors`
MAP_1 = ['02111',
         '01001',
         '01003',
         '01001',
         '01111']

Solution
(1, 0) with keys ''
(2, 0) with keys ''
(3, 0) with keys ''
(4, 0) with keys ''
(4, 1) with keys ''
(4, 2) with keys ''
`One door`
MAP_2 = ['02a11',
         '0100A',
         '01003',
         '01001',
         '01111']

Solution
Keys needed: a
(1, 0) with keys ''
(2, 0) with keys ''
(3, 0) with keys 'a'
(4, 0) with keys 'a'
(4, 1) with keys 'a'
(4, 2) with keys 'a'
*/

import java.util.*;
public class Solution {
    public List<String> pathFind(char[][] grid) {
        // find the starting point
        PathNode startingPoint = null, endingPoint = null;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '2') startingPoint = new PathNode(i, j, null, null);
            }
        }

        // BFS Search
        List<String> res = new ArrayList<>();
        Set<PathNode> visited = new HashSet<>();
        Queue<PathNode> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        queue.offer(startingPoint);
        while(!queue.isEmpty()) {
            PathNode curr = queue.poll();
            visited.add(curr);
            int currRow = curr.pos.row, currCol = curr.pos.col, currKeySet = curr.keySet;
            char currChar = grid[currRow][currCol];
            boolean hasKey = false;

            // base case
            if(currChar == '3') {
                endingPoint = curr;
                break;
            }

            // meet a key
            if(currChar >= 'a' && currChar <= 'z') {
                curr.keySet |= 1 << (currChar - 'a');
                hasKey = true;
            }

            // meet a gate but no key
            if(currChar >= 'A' && currChar <= 'Z' &&
                    ((currKeySet & 1 << (Character.toLowerCase(currChar) - 'A')) == 0)) continue;

            for(int[] dir: dirs) {
                int newRow = currRow + dir[0], newCol = currCol + dir[1];
                PathNode newNode = new PathNode(newRow, newCol, curr, hasKey ? currChar : null);
                if(newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length &&
                        grid[newRow][newCol] != '0' && !visited.contains(newNode)) {
                    queue.offer(newNode);
                }
            }
        }

        // output path
        PathNode curr = endingPoint;
        while(curr != startingPoint) {
            StringBuilder sb = new StringBuilder();
            sb.append(curr.pos.toString()).append(" with keys: ");
            int tmp = curr.keySet;
            for(int i = 0; i < 26; i++) {
                if((tmp & (1 << i)) != 0) sb.append((char)(i + 'a')).append(",");
            }
            curr = curr.parent;
            res.add(0, sb.toString().substring(0, sb.length() - 1));
        }
        res.add(0, startingPoint.pos.toString() + " with keys: ");
        return res;
    }

    class PathNode {
        public PathNode parent;
        public Position pos;
        public int keySet;

        public PathNode(int row, int col, PathNode parent, Character key) {
            pos = new Position(row, col);
            this.parent = parent;
            if(this.parent != null) keySet = this.parent.keySet;
            if(key != null) keySet |= 1 << (key - 'a');
        }

        public String toString() {
            return pos.toString() + ":" + keySet;
        }

        public int hashCode() {
            return 31 * pos.hashCode() + keySet;
        }

        public boolean equals(Object other) {
            PathNode o = (PathNode)other;
            return this.pos == o.pos && this.keySet == o.keySet;
        }
    }

    class Position {
        public int row, col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public String toString() {
            return "(" + row + "," + col + ")";
        }

        public int hashCode() {
            return 31 * row + col;
        }

        public boolean equals(Object o) {
            Position other = (Position)o;
            return other.row == this.row && other.col == this.col;
        }
    }
}


public class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] grid1 = new char[][]{
                {'0','2','1','1','1'},
                {'0','1','0','0','1'},
                {'0','1','0','0','3'},
                {'0','1','0','0','1'},
                {'0','1','1','1','1'}};
        char[][] grid2 = new char[][]{
                {'0','2','a','1','1'},
                {'0','1','0','0','A'},
                {'0','1','0','0','3'},
                {'0','1','0','0','1'},
                {'0','1','1','1','1'}};
        char[][] grid3 = new char[][]{{'a','2','A','3'}};
        char[][] grid4 = new char[][]{
                {'2','a','0','0'},
                {'b','0','0','0'},
                {'1','0','0','0'},
                {'1','A','B','3'}};
        System.out.println(sol.pathFind(grid1));
        System.out.println(sol.pathFind(grid2));
        System.out.println(sol.pathFind(grid3));
        System.out.println(sol.pathFind(grid4));
    }
}