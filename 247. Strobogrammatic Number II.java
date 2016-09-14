public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return findStrobogrammaticHelper(n, n);
    }
    
    public List<String> findStrobogrammaticHelper(int n, int remaining) {
        if(remaining == 0) return new ArrayList<>(Arrays.asList(""));
        if(remaining == 1) return new ArrayList<>(Arrays.asList("0","1","8"));
        
        List<String> subResult = findStrobogrammaticHelper(n, remaining - 2);
        List<String> result = new ArrayList<>();
        for(String s: subResult) {
            if(remaining != n) result.add("0" + s + "0");
            result.add("1" + s + "1");
            result.add("6" + s + "9");
            result.add("8" + s + "8");
            result.add("9" + s + "6");
        }
        return result;
    }
}