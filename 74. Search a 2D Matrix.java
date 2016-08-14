// regard the matrix as a 1D array
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length * matrix[0].length - 1, middle = 0;
        while(left < right) {
            middle = left + (right - left) / 2;
            int curr = matrix[middle / matrix[0].length][middle % matrix[0].length];
            if(curr == target) return true;
            else if(curr < target) left = middle + 1;
            else right = middle;
        }
        return matrix[left / matrix[0].length][left % matrix[0].length] == target;
    }
}

// binary search for the row and linear search for the col
/*
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowSize = matrix.length, colSize = matrix[0].length;
        for(int i=0; i<rowSize; i++) {
            if(target >= matrix[i][0] && target <= matrix[i][colSize-1]) {
                int left = 0, right = colSize - 1, middle = 0;
                while(left < right) {
                    middle = left + (right - left) / 2;
                    if(matrix[i][middle] == target) return true;
                    else if(matrix[i][middle] < target) left = middle + 1;
                    else right = middle;
                }
                if(matrix[i][left] == target) return true;
            }
        }
        return false;
    }
}
*/