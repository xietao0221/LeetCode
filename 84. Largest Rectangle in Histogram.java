// http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
// Similar to "Trapping Rain Water", but we should save increasing index and calculate when decreasing
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0, i = 0;
        Stack<Integer> stack = new Stack<>();
        while(i <= heights.length) {
            // iterate until i determining the decreasing, and calculate the area ending at (i-1)
            // so we need to build one more bar at the right of all bars, and its height is 0
            int h = i == heights.length ? 0 : heights[i];
            if(stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int topIndex = stack.pop();
                // stack is empty means there is not lower bars on the left, so the width is i
                // stack is not empty means thre is some lower bars on the left, we can only calculate a partial area
                int tmpArea = heights[topIndex] * (stack.isEmpty() ? i : i - 1 - stack.peek());
                res = Math.max(tmpArea, res);
                // after calculation, don't increase the i; only increase i when push into stack
            }
        }
        return res;
    }
}