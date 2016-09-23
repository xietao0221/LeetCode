// https://discuss.leetcode.com/topic/30621/1ms-java-binary-search-dfs-is-4ms
public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int rowNum = image.length, colNum = image[0].length;
        
        int colMin = binarySearch(image, true, 0, y, 0, rowNum, true);
        int colMax = binarySearch(image, true, y + 1, colNum, 0, rowNum, false);
        int rowMin = binarySearch(image, false, 0, x, colMin, colMax, true);
        int rowMax = binarySearch(image, false, x + 1, rowNum, colMin, colMax, false);
        
        return (rowMax - rowMin) * (colMax - colMin);
    }
    
    // biLow and biHigh is the bound of binary search
    // conLow and conHigh is the bound of the other dimension
    public int binarySearch(char[][] image, boolean horizontal, int biLow, int biHigh,
                            int conLow, int conHigh, boolean goLower) {
        while(biLow < biHigh) {
            int biMid = biLow + (biHigh - biLow) / 2;
            boolean inside = false;
            for(int i = conLow; i < conHigh; i++) {
                if((horizontal ? image[i][biMid] : image[biMid][i]) == '1') {
                    inside = true;
                    break;          // break immediately, because we need to expand the range
                }
            }
            
            // use inside and goLower to get the direction: expand or shrink
            if(inside == goLower) biHigh = biMid;
            else biLow = biMid + 1;
        }
        return biLow;
    }
}