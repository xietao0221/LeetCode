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
public class PathFinding {
    public static void main(String[] args) {
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
        System.out.println(pathFind(grid1));
        System.out.println(pathFind(grid2));
        System.out.println(pathFind(grid3));
        System.out.println(pathFind(grid4));
    }

    public static List<String> pathFind(char[][] grid) {
        // find the starting point
        PathNode startingPoint = null, endingPoint = null;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '2') {
                    startingPoint = new PathNode(i, j, null, null);
                }
            }
        }

        // BFS Search
        List<String> res = new ArrayList<>();
        Map<Position, Set<Set<Character>>> visited = new HashMap<>();
        Queue<PathNode> queue = new LinkedList<>();
        queue.offer(startingPoint);
        while(!queue.isEmpty()) {
            PathNode curr = queue.poll();

            // base case
            if(curr.pos.row < 0 || curr.pos.col < 0 || curr.pos.row >= grid.length ||
                    curr.pos.col >= grid[0].length || grid[curr.pos.row][curr.pos.col] == '0' ||
                    isVisited(curr, visited)) continue;
            if(grid[curr.pos.row][curr.pos.col] == '3') {
                endingPoint = curr;
                break;
            }


            char tmpChar = grid[curr.pos.row][curr.pos.col];
            // meet a gate without its key
            if(tmpChar >= 'A' && tmpChar <= 'Z' && !curr.keys.contains(Character.toLowerCase(tmpChar))) continue;
            // find a key
            if(tmpChar >= 'a' && tmpChar <= 'z') curr.keys.add(tmpChar);

            // search 4 directions
            queue.add(new PathNode(curr.pos.row-1, curr.pos.col, curr,
                    (tmpChar >= 'a' && tmpChar <= 'z' ? tmpChar : null)));
            queue.add(new PathNode(curr.pos.row+1, curr.pos.col, curr,
                    (tmpChar >= 'a' && tmpChar <= 'z' ? tmpChar : null)));
            queue.add(new PathNode(curr.pos.row, curr.pos.col-1, curr,
                    (tmpChar >= 'a' && tmpChar <= 'z' ? tmpChar : null)));
            queue.add(new PathNode(curr.pos.row, curr.pos.col+1, curr,
                    (tmpChar >= 'a' && tmpChar <= 'z' ? tmpChar : null)));

            // make this land(row, col, keys) visited
            if(!visited.containsKey(curr.pos)) visited.put(curr.pos, new HashSet<>());
            visited.get(curr.pos).add(curr.keys);
        }

        // backtracking
        PathNode curr = endingPoint;
        while(curr != startingPoint) {
            StringBuilder sb = new StringBuilder();
            sb.append('(').append(curr.pos.row).append(", ").append(curr.pos.col).append(") with keys: '");
            for(char c: curr.keys) sb.append(c).append("', '");
            res.add(0, sb.toString().substring(0, sb.length()-3));
            curr = curr.parent;
        }
        res.add(0, "(" + startingPoint.pos.row + ", " + startingPoint.pos.col + ") with keys: ''");
        return res;
    }

    // decide if this cell is visited before
    // we need to check three items: row, col, and keys
    static public boolean isVisited(PathNode target, Map<Position, Set<Set<Character>>> visited) {
        Position targetPos = new Position(target.pos.row, target.pos.col);
        if(!visited.containsKey(targetPos)) return false;
        for(Set<Character> set: visited.get(targetPos)) {
            if(set.size() != target.keys.size()) continue;
            int count = 0;
            for(char c: set) {
                if(target.keys.contains(c)) count++;
            }
            if(count == set.size()) return true;
        }
        return false;
    }

    // Wrapper class for backtracking
    // add parent node for the path finding
    static class PathNode {
        PathNode parent;
        Position pos;
        Set<Character> keys = new HashSet<>();
        public PathNode(int row, int col, PathNode parent, Character key) {
            this.pos = new Position(row, col);
            this.parent = parent;
            if(this.parent != null) {
                this.keys = new HashSet<>(this.parent.keys);
            }
            if(key != null) this.keys.add(key);
        }
    }

    // Wrapper class for Position
    // override the equals() for the convenience of visited() function
    static class Position {
        int row, col;
        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public boolean equals(Object o) {
            Position other = (Position)o;
            return other.row == this.row && other.col == this.col;
        }
    }
}



import java.util.*;

/**
 * Created by kangw on 7/25/16.
 */
public class WaterLandGame {

    public static void main(String[] args){
        WaterLandGame w1 = new WaterLandGame();
//        Character[][] grid =   {{'0','2','a','1','1'},
//                                {'0','1','0','0','A'},
//                                {'0','1','0','0','3'},
//                                {'0','1','0','0','1'},
//                                {'0','1','1','1','1'}};
        Character[][] grid = {{'a','2','A','3'}};
        w1.findPath(grid,0,1);
    }

    public List<String> findPath(Character[][] grid, int x, int y){
        List<String> result = new LinkedList<>();
        if (grid == null || grid.length == 0 || grid[0].length == 0) return result;
        int m = grid.length, n = grid[0].length;

        Pair cur = new Pair(null, x, y, 0);
        LinkedList<Pair> queue = new LinkedList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        queue.offer(cur);
        map.put(x*n+y,0);

        while (!queue.isEmpty()){
            cur = queue.poll();
            if (grid[cur.x][cur.y] == '3') break;
            if (isValid(cur.x+1,cur.y,cur.keys,grid,map)){
                Pair newPair = PairBuilder(cur.x + 1, cur.y, cur, grid);
                map.put(newPair.x*n+newPair.y,newPair.keys);
                queue.offer(newPair);
            }

            if (isValid(cur.x-1,cur.y,cur.keys,grid,map)){
                Pair newPair = PairBuilder(cur.x -1, cur.y, cur, grid);
                map.put(newPair.x*n+newPair.y,newPair.keys);
                queue.offer(newPair);
            }

            if (isValid(cur.x,cur.y+1,cur.keys,grid,map)){
                Pair newPair = PairBuilder(cur.x, cur.y+1, cur, grid);
                map.put(newPair.x*n+newPair.y,newPair.keys);
                queue.offer(newPair);
            }

            if (isValid(cur.x,cur.y-1,cur.keys,grid,map)){
                Pair newPair = PairBuilder(cur.x, cur.y-1, cur, grid);
                map.put(newPair.x*n+newPair.y,newPair.keys);
                queue.offer(newPair);
            }
        }

        while (cur != null){
            String s = String.valueOf(cur.x) + "," + String.valueOf(cur.y);
            result.add(0,s);
            cur = cur.pre;
        }

        return result;
    }

    private boolean isValid(int i, int j ,int keys,Character[][] grid, HashMap<Integer,Integer> map){
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length) return false;

        int index = i*grid[0].length +j;
        Integer preKey = map.get(index);

        // check if it is land or water or door
        if (grid[i][j] == '0') return false;
        else if (grid[i][j]>='A' && grid[i][j]<='Z') {
            if ((keys & (1<<(grid[i][j]-'A'))) == 0) return false;
            else return true;
        }else {
            if (preKey == null || !preKey.equals(keys)) return true;
            else return false;
        }

    }

    private Pair PairBuilder(int i, int j,Pair cur, Character[][] grid){

        if (grid[i][j]>= 'a' && grid[i][j]<='z'){
            return new Pair(cur,i,j,cur.keys|(1<<grid[i][j]-'a'));
        }else if (grid[i][j] >= 'A' && grid[i][j] <= 'Z') {
            return new Pair(cur,i,j,cur.keys& ~(1<<grid[i][j]-'a'));
        }else{
            return new Pair(cur,i,j,cur.keys);
        }
    }

    public static class Pair{
        Pair pre;
        int keys;
        int x;
        int y;

        public Pair(Pair pre, int x, int y, int keys){
            this.pre = pre;
            this.x = x;
            this.y = y;
            this.keys = keys;
        }
    }
}
