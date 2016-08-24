public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        String ops = "+-*/";
        for(String token: tokens) {
            if(ops.indexOf(token) == -1) {
                stack.push(Integer.parseInt(token));
            } else {
                stack.push(operation(stack, token));
            }
        }
        return stack.pop();
    }
    
    private int operation(Stack<Integer> stack, String operator) {
        int num2 = stack.pop(), num1 = stack.pop();
        if(operator.equals("+")) return num1 + num2;
        else if(operator.equals("-")) return num1 - num2;
        else if(operator.equals("*")) return num1 * num2;
        else return num1 / num2;
    }
}