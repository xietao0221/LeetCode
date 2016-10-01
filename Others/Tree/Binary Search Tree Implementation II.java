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
            // this curr is greater than the key, so it cannot be the result
            return floorHelper(curr.left, key);
        } else {                                            
            // this curr is smaller than the key, so it could be the potential result, so record it
            Node floor = floorHelper(curr.right, key);

            // the return value is null means the right is null, 
            // so itself is the greatest one smaller than key, that is the result
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
            // this curr is greater than the key, so it could be the potential result, so record it
            Node ceiling = ceilingHelper(curr.left, key);

            // the return value is null means the left is null
            // so itself is the smallest one greater than the key, that is the result
            if(ceiling != null) return ceiling;
            else return curr;
        } else {
            // the curr is smaller than key, it cannot be the result
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
        // only create the new node when iterate to the null
        if(curr == null) return new Node(key, value);

        if(key == curr.key) {
            // if new key is duplicate, update its value
            curr.value = value;
        } else if(key < curr.key) {
            // append the return value to its left
            curr.left = putHelper(curr.left, key, value);
        } else {
            // append the return value to its right
            curr.right = putHelper(curr.right, key, value);
        }

        // update size
        curr.count = 1 + sizeHelper(curr.left) + sizeHelper(curr.right);

        // don't forget to return curr
        return curr;
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

    public Integer findByRank(int rank) {
        // check input value, if rank is higher than the size of tree, return null
        if(rank > size()) return null;

        return findByRankHelper(root, rank);
    }

    private Integer findByRankHelper(Node curr, int rank) {
        // check the curr's rank, to decide which branch we are going to search
        int currRank = getRank(curr.key);

        if(currRank == rank) {
            return curr.value;
        } else if(currRank < rank) {
            return findByRankHelper(curr.right, rank);
        } else {
            return findByRankHelper(curr.left, rank);
        }
    }

    public void delete(int key) {
        root = deleteHelper(root, key);
    }

    private Node deleteHelper(Node curr, int key) {
        if(curr == null) return null;

        if(key == curr.key) {
            // if there is no right child, we just append curr.left to curr.parent
            if(curr.right == null) return curr.left;

            // if there are both left and right children, we need to swap curr with the smallest node in the right branch
            // save the deleteNode
            Node tmp = curr;
            // find the smallest node (swapped node)in the right branch
            curr = min(tmp.right);
            // connect this swapped node to its left and right
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

    // iterate the left-most node starting at curr
    private Node min(Node curr) {
        if(curr == null) return null;

        // the curr is the potential result, if return value is null, return curr, 
        // otherwise return the return value
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