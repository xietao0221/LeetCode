public class MyStack {
    public Node upNode = null, downNode = null;

    public MyStack() {
        upNode = new Node(0);
        downNode = new Node(0);
        upNode.down = downNode;
        downNode.up = upNode;
    }

    public void push(int x) {
        Node curr = new Node(x);

        curr.up = upNode;
        curr.down = upNode.down;

        upNode.down.up = curr;
        upNode.down = curr;
    }

    public void pop() {
        if(isEmpty()) return;
        upNode.down.down.up = upNode;
        upNode.down = upNode.down.down;
    }

    public Integer peek() {
        if(isEmpty()) return null;
        return upNode.down.data;
    }

    public boolean isEmpty() {
        return upNode.down == downNode;
    }

    class Node {
        public int data = 0;
        Node up = null, down = null;

        public Node(int data) {
            this.data = data;
        }
    }
}