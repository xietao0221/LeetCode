public class BinarySearchTree {
    private Node root;

    public Integer get(int key) {
        Node curr = root;
        while(curr != null) {
            if(key == curr.key) {
                return curr.value;
            } else if(key < curr.key) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return null;
    }

    public Integer floor(int key) {
        Node floor = floorHelper(root, key);

        if(floor != null) return floor.key;
        else return null;
    }

    private Node floorHelper(Node curr, int key) {
        if(curr == null) return null;

        if(key == curr.key) {
            return curr;
        } else if(key < curr.key) {
            return floorHelper(curr.left, key);
        } else {
            Node floor = floorHelper(curr.right, key);

            if(floor != null) return floor;
            else return curr;
        }
    }

    public Integer ceiling(int key) {
        Node ceiling = ceilingHelper(root, key);

        if(ceiling != null) return ceiling.key;
        else return null;
    }

    private Node ceilingHelper(Node curr, int key) {
        if(curr == null) return null;

        if(key == curr.key) {
            return curr;
        } else if(key < curr.key) {
            Node ceiling = ceilingHelper(curr.left, key);

            if(ceiling != null) return ceiling;
            else return curr;
        } else {
            return ceilingHelper(curr.right, key);
        }
    }

    public int size() {
        return sizeHelper(root);
    }

    private int sizeHelper(Node curr) {
        if(curr == null) return 0;
        else return curr.count;
    }


    public void put(int key, int value) {
        root = putHelper(root, key, value);
    }

    private Node putHelper(Node curr, int key, int value) {
        if(curr == null) return new Node(key, value);

        if(key == curr.key) {
            curr.value = value;
        } else if(key < curr.key) {
            curr.left = putHelper(curr.left, key, value);
        } else {
            curr.right = putHelper(curr.right, key, value);
        }

        curr.count = 1 + sizeHelper(curr.left) + sizeHelper(curr.right);
        return curr;
    }

    public Integer findByRank(int rank) {
        return findByRankHelper(root, rank);
    }

    private Integer findByRankHelper(Node curr, int rank) {
        int currRank = getRank(curr.key);

        if(currRank == rank) {
            return curr.value;
        } else if(currRank < rank) {
            return findByRankHelper(curr.right, rank);
        } else {
            return findByRankHelper(curr.left, rank);
        }

    }

    public int getRank(int key) {
        return getRankHelper(root, key);
    }

    private int getRankHelper(Node curr, int key) {
        if(curr == null) return 0;

        if(key == curr.key) {
            return sizeHelper(curr.left) + 1;
        } else if(key < curr.key) {
            return getRankHelper(curr.left, key);
        } else {
            return 1 + sizeHelper(curr.left) + getRankHelper(curr.right, key);
        }

    }

    public void delete(int key) {
        root = deleteHelper(root, key);
    }

    private Node deleteHelper(Node curr, int key) {
        if(curr == null) return null;

        if(key == curr.key) {
            if(curr.right == null) return curr.left;

            Node tmp = curr;
            curr = min(tmp.right);
            curr.right = deleteMinHelper(tmp.right);
            curr.left = tmp.left;
        } else if(key < curr.key) {
            curr.left = deleteHelper(curr.left, key);
        } else {
            curr.right = deleteHelper(curr.right, key);
        }
        curr.count = 1 + sizeHelper(curr.left) + sizeHelper(curr.right);
        return curr;
    }

    private Node min(Node curr) {
        if(curr == null) return null;

        Node min = min(curr.left);
        if(min != null) return min;
        else return curr;
    }

    public void deleteMin() {
        root = deleteMinHelper(root);
    }

    private Node deleteMinHelper(Node curr) {
        if(curr.left == null) return curr.right;

        curr.left = deleteMinHelper(curr.left);
        curr.count = 1 + sizeHelper(curr.left) + sizeHelper(curr.right);
        return curr;
    }

    public String inorderTraversal() {
        StringBuilder sb = new StringBuilder();
        inorderTraversalHelper(root, sb);
        return sb.toString();
    }

    private void inorderTraversalHelper(Node curr, StringBuilder sb) {
        if(curr == null) return;
        inorderTraversalHelper(curr.left, sb);
        sb.append("(").append(curr.key).append(",").append(curr.value).append(")");
        inorderTraversalHelper(curr.right, sb);
    }

    class Node {
        public int key, value, count = 1;
        public Node left = null, right = null;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return key + "," + value + "," + count;
        }
    }
}