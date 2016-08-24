public class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;

        // deal with the negative numbers
        if(s.charAt(0) == '-') s = "0" + s;
        s = s.replace("(-", "(0-");

        Stack<Character> ops = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        char[] sArray = s.toCharArray();

        for(int i = 0; i < sArray.length; i++) {
            char c = sArray[i];
            if(c >= '0' && c <= '9') {
                // get a complete number
                int currNum = c - '0';
                while(i + 1 < sArray.length && sArray[i + 1] >= '0' && sArray[i + 1] <= '9') {
                    currNum = 10 * currNum + (sArray[++i] - '0');
                }

                // it is safe to make a calculation only if the previous sign is * or /
                if(!ops.isEmpty() && (ops.peek() == '*' || ops.peek() == '/')) {
                    int num2 = currNum, num1 = nums.pop();
                    nums.push(operation(num1, num2, ops.pop()));
                } else {
                    // if don't make a calculation, don't forget to push this new number
                    nums.push(currNum);
                }
            } else if(c == '+' || c == '-') {
                // it is safe to make a calculation only if the previous sign is not (
                if(!ops.isEmpty() && ops.peek() != '(') {
                    int num2 = nums.pop(), num1 = nums.pop();
                    nums.push(operation(num1, num2, ops.pop()));
                }
                ops.push(c);
            } else if(c == '*' || c == '/') {
                ops.push(c);
            } else if(c == '(') {
                ops.push(c);
            } else if(c == ')') {
                // make as many calculations as possible until the previous sign is (
                while(ops.peek() != '(') {
                    int num2 = nums.pop(), num1 = nums.pop();
                    nums.push(operation(num1, num2, ops.pop()));
                }

                // don't forget to pop out the matching '('
                ops.pop();
            }
        }

        // before return, pop out two stacks and do the rest of calculations
        while(!ops.isEmpty()) {
            int num2 = nums.pop(), num1 = nums.pop();
            nums.push(operation(num1, num2, ops.pop()));
        }
        return nums.peek();
    }

    private int operation(int num1, int num2, char op) {
        if(op == '+') {
            return num1 + num2;
        } else if(op == '-') {
            return num1 - num2;
        } else if(op == '*') {
            return num1 * num2;
        } else {
            return num1 / num2;
        }
    }
}