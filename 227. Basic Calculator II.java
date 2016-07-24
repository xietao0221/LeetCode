public class Solution {
    // push to stack when operation occurs
    public int calculate(String s) {
        // save all units like "+5", "+4*5*6", "-4/5"
        Stack<Integer> stack = new Stack<>();
        int num = 0, res = 0;
        char sign = '+';
        char[] sArray = s.toCharArray();
        for(int i=0; i<sArray.length; i++) {
            char c = sArray[i];
            if(c >= '0' && c <= '9') {
                // avoid overflow
                if(10 * num + (c - '0') > Integer.MAX_VALUE) num = Integer.MAX_VALUE;
                else num = 10 * num + (c - '0');
            }
            
            if(c == '+' || c == '-' || c == '*' || c == '/' || i == sArray.length-1) {
                // whether pop from stack depends on the previous sign
                if(sign == '+' || sign == '-') {
                    // just plus the new number, but save it to the stack in case the next operation is '*' or '/'
                    int tmp = sign == '+' ? num : -num;
                    stack.push(tmp);
                    res += tmp;
                } else {
                    // have to pop out a number from stack and combine with the new number
                    res -= stack.peek();
                    int tmp = sign == '*' ? stack.pop() * num : stack.pop() / num;
                    stack.push(tmp);
                    res += tmp;
                }
                sign = c;
                num = 0;
            }
        }
        return res;
    }
}