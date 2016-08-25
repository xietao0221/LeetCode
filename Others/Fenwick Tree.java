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

    public FenwickTree(int[] input) {
        fenwickTree = new int[input.length + 1];
        originalNums = new int[input.length];
        for(int i = 0; i < input.length; i++) {
            updateValue(i, input[i]);
        }
    }

    // update the value of element at 'index' of original array
    public void updateValue(int index, int value) {
        int diff = value - originalNums[index];
        originalNums[index] = value;
        for(int i = index + 1; i < fenwickTree.length; i += i & (-i)) {
            fenwickTree[i] += diff;
        }
    }

    // get the sum of (0, index) of original array
    public int getSum(int index) {
        int sum = 0;
        for(int i = index + 1; i > 0; i -= i & (-i)) {
            sum += fenwickTree[i];
        }
        return sum;
    }
}