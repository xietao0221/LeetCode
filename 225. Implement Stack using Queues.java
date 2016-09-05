class MyStack {
    Queue<Integer> queue = new LinkedList<>();
    
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
        for(int i = 0; i < queue.size() - 1; i++) queue.add(queue.poll());
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.remove();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}