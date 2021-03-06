// similar to '84. Largest Rectangle in Histogram'
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        
        int[] heights = new int[matrix[0].length];
        int res = 0;
        for(int i = 0; i < matrix.length; i++) {
            calHeight(matrix, i, heights);
            res = Math.max(res, largestRectangleArea(heights));
        }
        return res;
    }
    
    private void calHeight(char[][] matrix, int row, int[] heights) {
        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[row][j] == '1') heights[j]++;
            else heights[j] = 0;
        }
    }
    
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int index = 0, res = 0;
        while(index <= heights.length) {
            int h = index == heights.length ? 0 : heights[index];
            if(stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(index++);
            } else {
                int topIndex = stack.pop();
                int localMax = heights[topIndex] * (stack.isEmpty() ? index : index - 1 - stack.peek());
                res = Math.max(res, localMax);
            }
        }
        return res;
    }
}

// DP Solution
/*
https://discuss.leetcode.com/topic/6650/share-my-dp-solution
left(i,j) = max(left(i-1,j), cur_left)
right(i,j) = min(right(i-1,j), cur_right)
height(i,j) = height(i-1,j) + 1, if matrix[i][j]=='1';
height(i,j) = 0, if matrix[i][j]=='0'
area = [right(i,j) - left(i,j) + 1] * height(i,j).
*/
/*
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        
        // use 1d array to do the DP, because DP is only related to its previous row and previous col
        int[] left = new int[matrix[0].length], right = new int[matrix[0].length], height = new int[matrix[0].length];
        int res = 0;
        
        // initialize the dp_right array
        for(int i = 0; i < right.length; i++) right[i] = matrix[0].length - 1;
        
        // iterate the whole matrix row by row, and calculate the dp arrays
        for(int i = 0; i < matrix.length; i++) {
            // if matrix[i][j] == 0, anything in left[j] and right[j] is useless
            // because at this time, height[j] is 0, and then the area is 0
            // the reason why make default 'useless' value to be 0 or n-1 is to make comparison(max, min) easier
            int currLeft = 0, currRight = matrix[0].length - 1;
            
            // right array: right->left
            for(int j = matrix[0].length - 1; j >= 0; j--) {
                if(matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], currRight);
                } else {
                    right[j] = matrix[0].length - 1;    // the right[j] is got by Min, so no boundary is represented using n-1
                    currRight = j - 1;              // the current cell is 0, so set currRight to the next potential position
                }
            }
            
            // left array: left->right; height array: left->right; 
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], currLeft);
                    
                    height[j]++;
                    
                    // only calculate area when height[j] is not 0
                    res = Math.max(res, (right[j] - left[j] + 1) * height[j]);
                } else {
                    left[j] = 0;        // the left[j] is got by Max, so no boundary is represented using 0
                    currLeft = j + 1;   // the current cell is 0, so set the currLeft to the next potential position
                    
                    height[j] = 0;
                }
            }
        }
        return res;
    }
}
*/