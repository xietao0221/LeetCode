public class Solution {
    public String parseTernary(String expression) {
        char[] exp = expression.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = exp.length - 1; i >= 0; i--) {
            if(!stack.isEmpty() && stack.peek() == '?') {
                stack.pop();        // pop '?'
                char first = stack.pop();
                stack.pop();        // pop ':'
                char second = stack.pop();
                stack.push(exp[i] == 'T' ? first : second);
            } else {
                stack.push(exp[i]);
            }
        }
        return stack.pop().toString();
    }
}