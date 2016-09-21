// solution 1
public class Solution {
    // push to stack when operation occurs
    public int calculate(String s) {
        // save all units like "+5", "+4*5*6", "-4/5"
        Stack<Integer> stack = new Stack<>();
        int num = 0, res = 0;
        char prevSign = '+';
        char[] sArray = s.toCharArray();
        
        for(int i = 0; i < sArray.length; i++) {
            char c = sArray[i];
            
            if(c >= '0' && c <= '9') {
                int digit = c - '0';
                num = 10 * num + (c - '0');
                while(i + 1 < sArray.length && (sArray[i + 1] >= '0' && sArray[i + 1] <= '9')) {
                    num = 10 * num + (sArray[++i] - '0');
                }
            }
            
            if(c == '+' || c == '-' || c == '*' || c == '/' || i == sArray.length - 1) {
                // whether pop from stack depends on the previous sign
                if(prevSign == '+' || prevSign == '-') {
                    // just plus the new number, but save it to the stack in case the next operation is '*' or '/'
                    int tmp = prevSign == '+' ? num : -num;
                    stack.push(tmp);
                    res += tmp;
                } else {
                    // have to pop out a number from stack and combine with the new number
                    int prev = stack.pop();
                    res -= prev;
                    int tmp = prevSign == '*' ? prev * num : prev / num;
                    stack.push(tmp);
                    res += tmp;
                }
                prevSign = c;
                num = 0;
            }
        }
        return res;
    }
}

// solution 2
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
                while(i + 1 < sArray.length && sArray[i+1] >= '0' && sArray[i+1] <= '9') {
                    currNum = 10 * currNum + (sArray[++i] - '0');
                }
                
                if(!ops.isEmpty() && (ops.peek() == '*' || ops.peek() == '/')) {
                    int num2 = currNum, num1 = nums.pop();
                    nums.push(operation(num1, num2, ops.pop()));
                } else {
                    nums.push(currNum);
                }
            } else if(c == '+' || c == '-') {
                if(!ops.isEmpty()) {
                    int num2 = nums.pop(), num1 = nums.pop();
                    nums.push(operation(num1, num2, ops.pop()));
                }
                ops.push(c);
            } else if(c == '*' || c == '/') {
                ops.push(c);    
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