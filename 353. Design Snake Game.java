public class SnakeGame {
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */

    private int width, height, row = 0, col = 0, score = 0, index = 0;
    private int[][] food;
    private Deque<Position> snakeList = new LinkedList<>();
    private Set<Position> snakeSet = new HashSet<>();

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        Position head = new Position(0, 0);
        snakeList.offerLast(head);
        snakeSet.add(head);
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        // have to remove tail first and then check if the new head is contained by snake body
        Position tail = snakeList.pollFirst();
        snakeSet.remove(tail);
        
        if(direction.equals("U")) row--;
        else if(direction.equals("L")) col--;
        else if(direction.equals("R")) col++;
        else row++;
        
        Position head = new Position(row, col);
        if(row < 0 || col < 0 || row >= height || col >= width || snakeSet.contains(head)) return -1;
        
        snakeList.offerLast(head);
        snakeSet.add(head);
        if(score < food.length && food[index][0] == row && food[index][1] == col) {
            score++;
            index++;
            snakeList.addFirst(tail);
            snakeSet.add(tail);
        }
        return score;
    }
    
    // must implement hashCode() and equals() methods
    class Position {
        public int row, col;
        
        public Position(int x, int y) {
            this.row = x;
            this.col = y;
        }

        public boolean equals(Object other) {
            Position o = (Position) other;
            return this.row == o.row && this.col == o.col;
        }
        
        public int hashCode() {
            int res = 0;
            res = 31 * res + this.row;
            res = 31 * res + this.col;
            return res;
        }
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */