// https://leetcode.com/discuss/15634/a-stack-based-solution-for-reference-inspired-by-histogram
public class Solution {
    // use one stack: always save the bar in decreasing order
    // find 3 index(like a container): left highest, middle bottom, right highest
    // water += (min(height[right], height[left]) - height[bottom]) * (right - left - 1)
    public int trap(int[] height) {
        int water = 0, i = 0;
        Stack<Integer> stack = new Stack<>();       // save the index of bar
        while(i < height.length) {
            // for the left-most: stack.isEmpty() to avoid missing left bar
            // fot the right-most: height[i] <= height[stack.peek()] to avoid culculate water if no right higher bar
            if(stack.isEmpty() || height[stack.peek()] >= height[i]) {
                // stack is empty means there is no bar on the left, we should put a bar for a container
                // when decreasing, we save all indeces
                stack.push(i++);                    // only increase the index when push index into stack
            } else {
                // when a container is formed: decreasing and increasing
                int bottomIndex = stack.pop();
                
                // if there is no bar on the left, we don't need to accumulate water
                if(!stack.empty()) {
                    int rightIndex = i, leftIndex = stack.peek();
                    water += (Math.min(height[rightIndex], height[leftIndex]) - height[bottomIndex]) *
                        (rightIndex - leftIndex - 1);
                }
            }
        }
        return water;
    }
}