public class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] res = new int[rowIndex + 1];
        res[0] = 1;
        for(int i=1; i<rowIndex + 1; i++) {
            for(int j=i; j>=0; j--) {
                res[j] += res[j-1];
            }
        }
        return Arrays.asList<>(res);
    }
}