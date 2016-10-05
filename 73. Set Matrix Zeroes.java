/*
for each col, if there is a 0, mark it in the first row
for each row, if there is a 0, mark it in the first col
because we use the first row/col as the marker, we need two more boolean var to save whether the first row/col has 0
*/
public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row0HasZero = false, col0HasZero = false;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) row0HasZero = true;
                    if(j == 0) col0HasZero = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        //check if row0HasZero and col0HasZero are marked
        if(row0HasZero) {
            for(int j = 0; j < matrix[0].length; j++) matrix[0][j] = 0;
        }
        
        if(col0HasZero) {
            for(int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
        }
    }
}