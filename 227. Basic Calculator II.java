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
                // avoid overflow
                int digit = c - '0';
                if(10 * num + digit > Integer.MAX_VALUE) num = Integer.MAX_VALUE;
                else num = 10 * num + digit;
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