//把他按行扫描，每一行看成一个histogram
//然后运行84题的在histogram里面找最大长方形
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int res = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == '1') {
                    heights[j]++;
                } else heights[j] = 0;
            }
            res = Math.max(res, maxHistogram(heights));
        }
        return res;
    }
    public int maxHistogram(int[] heights) {
        int len = heights.length;
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++) {
            int h = i == len ? 0 : heights[i];
            if(stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int tp = stack.pop();
                maxArea = Math.max(maxArea, heights[tp] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                i--;
            }
        }
        return maxArea;
    }
}

public class Solution {
    static class Block {
        public int height;
        public int leftBoundary;
        public int rightBoundary;
        public Block(int rightBoundary) {
            height = 0;
            leftBoundary = 0;
            this.rightBoundary = rightBoundary;
        }
        public int area() {
            return (rightBoundary - leftBoundary) * height;
        }
    }
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (0 == row) return 0;
        int col = matrix[0].length;
        if (0 == col) return 0;
        Block[] blocks = new Block[col];
        for (int y = 0; y < col; ++y) {
            blocks[y] = new Block(col);
        }
        int result = 0;
        for (int x = 0; x < row; ++x) {
            int leftStart = 0;
            for (int y = 0; y < col; ++y) {
                if (matrix[x][y] == '1') {
                    blocks[y].height++;
                    blocks[y].leftBoundary = Math.max(blocks[y].leftBoundary, leftStart);
                } else {
                    blocks[y].height = 0;
                    leftStart = y+1;
                    blocks[y].leftBoundary = 0;
                }
            }
            int rightStart = col;
            for (int y = col-1; y >= 0; --y) {
                if (matrix[x][y] == '1') {
                    blocks[y].rightBoundary = Math.min(blocks[y].rightBoundary, rightStart);
                } else {
                    rightStart = y;
                    blocks[y].rightBoundary = col;
                }
            }
            for (int y = 0; y < col; ++y) {
                result = Math.max(result, blocks[y].area());
            }
        }
        return result;
    }
}