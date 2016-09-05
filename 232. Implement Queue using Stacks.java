class MyQueue {
    Stack<Integer> queue = new Stack<>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while(!queue.isEmpty()) temp.push(queue.pop());
        queue.push(x);
        while(!temp.isEmpty()) queue.push(temp.pop());
    }

    // Removes the element from in front of queue.
    public void pop() {
        queue.pop();
    }

    // Get the front element.
    public int peek() {
        return queue.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}