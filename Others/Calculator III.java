static int calculate(String s) {
        if(s == null || s.length() == 0) return -1;
        Stack<Character> ops = new Stack<>();
        Stack<Integer> nums = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(Character.isDigit(curr)) {
                int num = curr - '0';
                while(i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = 10 * num + (s.charAt(++i) - '0');
                }
                if(!ops.isEmpty() && (ops.peek() == '*' || ops.peek() == '/')) {
                    num = operation(nums.pop(), num, ops.pop());
                }
                nums.push(num);
            } else if(curr == '(') {
                ops.push(curr);
            } else if(curr == ')') {
                while(ops.peek() != '(') {
                    updateStack(nums, ops);
                }
                // pop out the matching '('
                ops.pop();
            } else if(curr == '*' || curr == '/') {
                ops.push(curr);
            } else if(curr == '+' || curr == '-') {
                updateStack(nums, ops);
                ops.push(curr);
            }
        }

        updateStack(nums, ops);
        return nums.peek();
    }

    static int operation(int num1, int num2, char op) {
        if(op == '+') {
            return num1 + num2;
        } else if(op == '-') {
            return num1 - num2;
        } else if(op == '*') {
            return num1 * num2;
        } else if(op == '/') {
            return num1 / num2;
        } else {
            return -1;
        }
    }

    static void updateStack(Stack<Integer> nums, Stack<Character> ops) {
        if(!ops.isEmpty() && ops.peek() != '(') {
            int num2 = nums.pop(), num1 = nums.pop();
            nums.push(operation(num1, num2, ops.pop()));
        }
    }