public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num == null || num.length() == 0) return res;
        addOperatorsHelper(num, target, res, new StringBuilder(), 0, 0, 0);
        return res;
    }
    
    public void addOperatorsHelper(String num, int target, List<String> res,
                                   StringBuilder expression, int position, long result, long multiple) {
        if(position == num.length()) {
            if(result == target) res.add(expression.toString());
            return;
        }

        int len = expression.length();
        for(int i=position; i<num.length(); i++) {
            // there no digit behind '0' if '0' is the starting digit
            if(num.charAt(position) == '0' && i != position) break;
            long curr = Long.parseLong(num.substring(position, i+1));
            
            if(position == 0) {
                // only add
                expression.append(curr);
                addOperatorsHelper(num, target, res, expression, i+1, curr, curr);
                expression.setLength(len);
            } else {
                // add
                expression.append("+").append(curr);
                addOperatorsHelper(num, target, res, expression, i+1, result+curr, curr);
                expression.setLength(len);

                // subtract
                expression.append("-").append(curr);
                addOperatorsHelper(num, target, res, expression, i+1, result-curr, -curr);
                expression.setLength(len);

                // multiple
                expression.append("*").append(curr);
                addOperatorsHelper(num, target, res, expression, i+1, result-multiple+multiple*curr, multiple*curr);
                expression.setLength(len);
            }
        }
    }
}