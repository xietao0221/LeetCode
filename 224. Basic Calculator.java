/*
Start from +1 sign and scan s from left to right;
if c == digit: This number = Last digit * 10 + This digit;
if c == '+': Add num to result before this sign; This sign = Last context sign * 1; clear num;
if c == '-': Add num to result before this sign; This sign = Last context sign * -1; clear num;
if c == '(': Push this context sign to stack;
if c == ')': Pop this context and we come back to last context;
Add the last num. This is because we only add number after '+' / '-'.
*/
public class Solution {
    public int calculate(String s) {
        // the stack saves signs
        Stack<Integer> stack = new Stack<>();
        int prevSign = 1, num = 0, res = 0;
        char[] sArray = s.trim().toCharArray();
        stack.push(prevSign);
        
        for(int i = 0; i < sArray.length; i++) {
            char c = sArray[i];
            if(c >= '0' && c <= '9') {
                // avoid the overflow
                int digit = c - '0';
                if(10 * num + digit > Integer.MAX_VALUE) num = Integer.MAX_VALUE;
                else num = 10 * num + digit;
            } else if(c == '+' || c == '-') {
                res += prevSign * num;
                // always change the sign based on the sign before '(', which get rid of the hurt of '(' and ')'
                // must multiple stack.peek() to deal with 'minus before (' case
                prevSign = stack.peek() * (c == '+' ? 1 : -1);
                num = 0;
            } else if(c == '(') {
                stack.push(prevSign);
            } else if(c == ')') {
                stack.pop();
            }
        }
        // deal with the case that last character is ')'
        // because we only change res after '+' and '-'
        res += prevSign * num;
        return res;
    }
}