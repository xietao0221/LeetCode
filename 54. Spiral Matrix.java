public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;
        
        int rowMin = 0, rowMax = matrix.length - 1, colMin = 0, colMax = matrix[0].length - 1;
        while(rowMin <= rowMax && colMin <= colMax) {
            for(int col=colMin; col<=colMax; col++) list.add(matrix[rowMin][col]);
            rowMin++;
            
            for(int row=rowMin; row<=rowMax; row++) list.add(matrix[row][colMax]);
            colMax--;
            
            if(rowMin > rowMax || colMin > colMax) break;       // must add this line, for the case {{2},{3}}
            
            for(int col=colMax; col>=colMin; col--) list.add(matrix[rowMax][col]);
            rowMax--;
            
            for(int row=rowMax; row>=rowMin; row--) list.add(matrix[row][colMin]);
            colMin++;
        }
        return list;
    }
}