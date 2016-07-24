public class Solution {
    /*
    Start from +1 sign and scan s from left to right;
    if c == digit: This number = Last digit * 10 + This digit;
    if c == '+': Add num to result before this sign; This sign = Last context sign * 1; clear num;
    if c == '-': Add num to result before this sign; This sign = Last context sign * -1; clear num;
    if c == '(': Push this context sign to stack;
    if c == ')': Pop this context and we come back to last context;
    Add the last num. This is because we only add number after '+' / '-'.
    */
    public int calculate(String s) {
        // the stack saves signs
        Stack<Integer> stack = new Stack<>();
        int sign = 1, num = 0, res = 0;
        stack.push(sign);
        
        for(char c: s.toCharArray()) {
            if(c >= '0' && c <= '9') {
                // avoid the overflow
                if(10 * num + (c - '0') > Integer.MAX_VALUE) num = Integer.MAX_VALUE;
                else num = 10 * num + (c - '0');
            } else if(c == '+' || c == '-') {
                res += sign * num;
                // must multiple stack.peek() to deal with 'minus before (' case
                sign = stack.peek() * (c == '+' ? 1 : -1);
                num = 0;
            } else if(c == '(') {
                stack.push(sign);
            } else if(c == ')') {
                stack.pop();
            }
        }
        // deal with the case that last character is ')'
        // because we only change res after '+' and '-'
        res += sign * num;
        return res;
    }
}