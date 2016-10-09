// DP Solution
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        if(triangle.size() == 1) return triangle.get(0).get(0);
        
        int res = Integer.MAX_VALUE;
        for(int i = 1; i < triangle.size(); i++) {
            List<Integer> prev = triangle.get(i - 1);
            List<Integer> curr = triangle.get(i);
            for(int j = 0; j < curr.size(); j++) {
                int left = j - 1 >= 0 ? prev.get(j - 1) : Integer.MAX_VALUE;    // left bound
                int up = j < prev.size() ? prev.get(j) : Integer.MAX_VALUE;     // right bound
                
                int tmp = Math.min(left, up) + curr.get(j);
                curr.set(j, tmp);
                
                // only get res when you get the last row
                if(i == triangle.size() - 1) res = Math.min(res, tmp);
            }
        }
        return res;
    }
}