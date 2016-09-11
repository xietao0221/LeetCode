public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] query) {
        // build the map
        Map<String, Map<String, Double>> map = new HashMap<>();
        for(int i = 0; i < equations.length; i++) {
            if(!map.containsKey(equations[i][0])) map.put(equations[i][0], new HashMap<>());
            map.get(equations[i][0]).put(equations[i][1], values[i]);

            if(!map.containsKey(equations[i][1])) map.put(equations[i][1], new HashMap<>());
            map.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }
        
        // search dividend and divisor using DFS
        double[] res = new double[query.length];
        for(int i = 0; i < query.length; i++) {
            double[] para = new double[]{1.0};
            if(calculate(map, query[i][0], query[i][1], para, new HashSet<>(), 1.0)) res[i] = para[0];
            else res[i] = -1.0;
        }
        return res;
    }
    
    // DFS
    private boolean calculate(Map<String, Map<String, Double>> map, String num1, String num2,
                              double[] para, Set<String> visited, double res) {
        if(!map.containsKey(num1) || !map.containsKey(num2) || visited.contains(num1)) return false;
        
        if(num1.equals(num2)) {
            para[0] = res;
            return true;
        }
        
        visited.add(num1);
        for(Map.Entry<String, Double> entry: map.get(num1).entrySet()) {
            if(calculate(map, entry.getKey(), num2, para, visited, res * entry.getValue())) return true;
        }
        visited.remove(num1);           // backtracking
        return false;
    }
}