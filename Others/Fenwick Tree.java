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
    private int[] fenwickTree, originalNums;

    // create fenwick tree
    public FenwickTree(int[] input) {
        fenwickTree = new int[input.length+1];
        originalNums = new int[input.length];

        // update the node from index 1 because node 0 is dummy node
        for(int i=0; i<input.length; i++) {
            originalNums[i] = input[i];
            updateFenwickTree(i + 1, input[i]);
        }
    }

    // modify the element of original array at 'index' to 'value'
    public void updateValue(int index, int value) {
        updateFenwickTree(index + 1, value - originalNums[index]);
    }

    // update the node of fenwick tree at 'index', and then update the its next ones
    private void updateFenwickTree(int index, int diff) {
        while(index < fenwickTree.length) {
            fenwickTree[index] += diff;
            index = getNext(index);
        }
    }

    // get the sum of (0, index) of original array
    public int getSum(int index) {
        index++;                // the # of node is one larger than index
        int sum = 0;
        while(index > 0) {      // index 0 is the dummy node
            sum += fenwickTree[index];
            index = getParent(index);
        }
        return sum;
    }

    // get the parent of node in fenwick tree
    private int getParent(int index) {
        return index - (index & -index);
    }

    // get the next of node in fenwick tree
    private int getNext(int index) {
        return index + (index & -index);
    }
}