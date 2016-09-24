/*
Given an array, output the first bigger number after it.
Ex. 
input: [1, 3, 2, 4]
output: 1 -> 3, 3 -> 4, 2 -> 4 
*/
public class Solution {
    public Map<Integer, Integer> findNextBiggerNum(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            if(stack.isEmpty() || stack.peek() > num) {
                stack.push(num);
            } else {
                while(!stack.isEmpty()) {
                    map.put(stack.pop(), num);
                }
                stack.push(num);
            }
        }
        return map;
    }
}