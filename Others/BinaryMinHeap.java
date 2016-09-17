public class BinaryMinHeap<T> {
    private List<Node> list = new ArrayList<>();
    private Map<T, Integer> positions = new HashMap<>();

    public boolean contains(T key) {
        return positions.containsKey(key);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void insert(T key, int weight) {
        // create new Node and put it into array list and map
        Node curr = new Node(key, weight);
        list.add(curr);
        int currIndex = list.size() - 1;
        positions.put(key, currIndex);

        // re-heapify with their parent
        reHeapifyBottomUP(currIndex);
    }

    public Integer getWeight(T key) {
        if(!contains(key)) return null;
        return list.get(positions.get(key)).weight;
    }

    private void decrease(T key, int newWeight) {
        // decrease the key
        int currIndex = positions.get(key);
        list.get(currIndex).weight = newWeight;

        // re-heapify with their parent
        reHeapifyBottomUP(currIndex);
    }

    private void increase(T key, int newWeight) {
        // increase the key
        int currIndex = positions.get(key);
        list.get(currIndex).weight = newWeight;

        // re-heapify with their children
        reHeapifyTopDown(currIndex);
    }

    public void modify(T key, int newWeight) {
        int oldWeight = list.get(positions.get(key)).weight;
        if(newWeight < oldWeight) decrease(key, newWeight);
        else if(newWeight > oldWeight) increase(key, newWeight);
    }

    public int extractMin() {
        int res = list.get(0).weight;

        // swap the top root with the right-most leaf, and then remove the last node
        swapNode(list.get(0), 0, list.get(list.size() - 1), list.size() - 1);
        list.remove(list.size() - 1);

        // re-heapify with their children
        reHeapifyTopDown(0);
        return res;
    }

    private void reHeapifyBottomUP(int currIndex) {
        int parentIndex = (currIndex - 1) / 2;
        while(parentIndex >= 0) {
            Node currNode = list.get(currIndex), parentNode = list.get(parentIndex);
            if(parentNode.weight > currNode.weight) {
                swapNode(currNode, currIndex, parentNode, parentIndex);
                currIndex = parentIndex;
                parentIndex = (currIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    private void reHeapifyTopDown(int currIndex) {
        while(true) {
            int leftChildIndex = 2 * currIndex + 1, rightChildIndex = leftChildIndex + 1;

            // get the smaller children
            if(leftChildIndex >= list.size()) break;
            if(rightChildIndex >= list.size()) rightChildIndex = leftChildIndex;
            int smallerChildIndex = list.get(leftChildIndex).weight < list.get(rightChildIndex).weight ?
                    leftChildIndex : rightChildIndex;

            // swap
            Node currNode = list.get(currIndex), smallerChildNode = list.get(smallerChildIndex);
            if(currNode.weight > smallerChildNode.weight) {
                swapNode(currNode, currIndex, smallerChildNode, smallerChildIndex);
                currIndex = smallerChildIndex;
            } else {
                return;
            }
        }
    }

    private void swapNode(Node node1, int index1, Node node2, int index2) {
        // swap in the hash map
        positions.put(node1.key, index2);
        positions.put(node2.key, index1);

        // swap in the array list
        T tmpKey = node1.key;
        int tmpWeight = node1.weight;

        node1.key = node2.key;
        node1.weight = node2.weight;

        node2.key = tmpKey;
        node2.weight = tmpWeight;
    }

    class Node {
        public T key = null;
        public int weight = 0;

        public Node(T key, int weight) {
            this.key = key;
            this.weight = weight;
        }
    }
}