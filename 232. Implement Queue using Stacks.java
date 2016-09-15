class MyQueue {
    private Stack<Integer> stack = new Stack<>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        // reorder the stack based on the order of queue after each pushing
        // this stack is a queue actually
        Stack<Integer> temp = new Stack<>();
        while(!stack.isEmpty()) temp.push(stack.pop());
        stack.push(x);
        while(!temp.isEmpty()) stack.push(temp.pop());
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}