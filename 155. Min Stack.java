class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();
    
    public void push(int x) {
        if(stackMin.isEmpty() || x <= getMin()) stackMin.push(x);
        stack.push(x);
    }

    public void pop() {
        int x = stack.pop();
        if(x == getMin()) stackMin.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}