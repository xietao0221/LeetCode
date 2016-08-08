// https://www.youtube.com/watch?v=CWDQJGaN1gY
/**
 * node 0 = dummy node
 * node 1 = 0 + 2^0 ==> (0,0)
 * node 2 = 0 + 2^1 ==> (0,1)
 * node 3 = 2^1 + 2^0 ==> (2,2)
 * node 4 = 0 + 2^2 ==> (0,3)
 * node 5 = 2^2 + 2^0 ==> (4,4)
 * node 6 = 2^2 + 2^1 ==> (4,5)
 * node 7 = 2^2 + 2^1 + 2^0 ==> (6,6)
 * node 8 = 0 + 2^3 ==> (0,7)
 * node 9 = 2^3 + 2^0 ==> (8,8)
 * node 10 = 2^3 + 2^1 ==> (8,9)
 * node 11 = 2^3 + 2^1 + 2^0 ==> (10,10)
 *
 * */
public class FenwickTree {
    /**
     * Start from index+1 if you updating index in original array. Keep adding this value
     * for next node till you reach outside range of tree
     */
    public void updateBinaryIndexedTree(int binaryIndexedTree[], int val, int index){
        while(index < binaryIndexedTree.length) {
            binaryIndexedTree[index] += val;
            index = getNext(index);
        }
    }

    /**
     * Start from index+1 if you want prefix sum 0 to index. Keep adding value
     * till you reach 0
     */
    public int getSum(int binaryIndexedTree[], int index) {
        index = index + 1;      // the # of node is one larger than index
        int sum = 0;
        while(index > 0) {
            sum += binaryIndexedTree[index];
            index = getParent(index);
        }
        return sum;
    }

    /**
     * Creating tree is like updating Fenwick tree for every value in array
     */
    public int[] createTree(int input[]) {
        int binaryIndexedTree[] = new int[input.length+1];
        for(int i=1; i <= input.length; i++){
            updateBinaryIndexedTree(binaryIndexedTree, input[i-1], i);
        }
        return binaryIndexedTree;
    }

    /**
     * To get parent
     * 1) 2's complement to get minus of index
     * 2) AND this with index
     * 3) Subtract that from index
     */
    private int getParent(int index) {
        return index - (index & -index);
    }

    /**
     * To get next
     * 1) 2's complement of get minus of index
     * 2) AND this with index
     * 3) Add it to index
     */
    private int getNext(int index) {
        return index + (index & -index);
    }
}