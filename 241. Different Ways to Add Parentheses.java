public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                List<Integer> part1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> part2 = diffWaysToCompute(input.substring(i + 1));
                for(Integer num1 : part1) {
                    for(Integer num2: part2) {
                        res.add(operation(num1, num2, c));
                    }
                }
            }
        }
        
        if(res.size() == 0) res.add(Integer.parseInt(input));
        return res;
    }
    
    private int operation(int num1, int num2, char op) {
        if(op == '+') return num1 + num2;
        else if(op == '-') return num1 - num2;
        else return num1 * num2;
    }
}