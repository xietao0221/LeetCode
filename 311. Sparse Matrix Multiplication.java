// suitable for sparse matrix
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        // get non zero element of A and B
        List<int[]> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        getNonZeroElement(A, list1);
        getNonZeroElement(B, list2);
        
        // calculation
        int[][] res = new int[A.length][B[0].length];
        for(int[] coor1: list1) {
            for(int[] coor2: list2) {
                if(coor1[1] == coor2[0]) res[coor1[0]][coor2[1]] += A[coor1[0]][coor1[1]] * B[coor2[0]][coor2[1]];
            }
        }
        return res;
    }
    
    private void getNonZeroElement(int[][] matrix, List<int[]> list) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] != 0) list.add(new int[]{i, j});
            }
        }
    }
}

// brute force
/*
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        for(int i = 0; i < A.length; i++) {
            for(int k = 0; k < A[0].length; k++) {
                if(A[i][k] == 0) continue;
                for(int j = 0; j < B[0].length; j++) {
                    if(B[k][j] == 0) continue;
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return res;
    }
}
*/