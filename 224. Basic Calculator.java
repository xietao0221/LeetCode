// Solution 1
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
                num = c - '0';
                while(i + 1 < sArray.length && (sArray[i + 1] >= '0' && sArray[i + 1] <= '9')) {
                    num = 10 * num + (sArray[i + 1] - '0');
                    i++;
                }
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

// Solution 2
/*
public class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] sArray = s.toCharArray();
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        
        for(int i = 0; i < sArray.length; i++) {
            char c = sArray[i];
            if(c >= '0' && c <= '9') {
                int currNum = c - '0';
                while(i + 1 < sArray.length && (sArray[i+1] >= '0' && sArray[i+1] <= '9')) {
                    currNum = 10 * currNum + (sArray[++i] - '0');
                }
                
                if(!ops.isEmpty() && (ops.peek() == '*' || ops.peek() == '/')) {
                    int num2 = currNum, num1 = nums.pop();
                    nums.push(operation(num1, num2, ops.pop()));
                } else {
                    nums.push(currNum);
                }
            } else if(c == '+' || c == '-') {
                if(!ops.isEmpty() && ops.peek() != '(') {
                    int num2 = nums.pop(), num1 = nums.pop();
                    nums.push(operation(num1, num2, ops.pop()));
                }
                ops.push(c);
            } else if(c == '(') {
                ops.push(c);
            } else if(c == ')') {
                while(ops.peek() != '(') {
                    int num2 = nums.pop(), num1 = nums.pop();
                    nums.push(operation(num1, num2, ops.pop()));
                }
                ops.pop();
            }
        }
        
        while(!ops.isEmpty()) {
            int num2 = nums.pop(), num1 = nums.pop();
            nums.push(operation(num1, num2, ops.pop()));
        }
        return nums.pop();
    }
    
    private int operation(int num1, int num2, char op) {
        if(op == '+') return num1 + num2;
        else if(op == '-') return num1 - num2;
        else if(op == '*') return num1 * num2;
        else return num1 / num2;
    }
}
*/