public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        if(triangle.size() == 1) return triangle.get(0).get(0);
        int res = Integer.MAX_VALUE;
        
        for(int i = 1; i < triangle.size(); i++) {
            List<Integer> prev = triangle.get(i - 1);
            List<Integer> curr = triangle.get(i);
            for(int j = 0; j < curr.size(); j++) {
                int left = j - 1 >= 0 && j - 1 < prev.size() ? prev.get(j - 1) : Integer.MAX_VALUE;
                int mid = j >= 0 && j < prev.size() ? prev.get(j) : Integer.MAX_VALUE;
                int tmp = Math.min(left, mid) + curr.get(j);
                curr.set(j, tmp);
                if(i == triangle.size() - 1) res = Math.min(res, tmp);
            }
        }
        return res;
    }
}