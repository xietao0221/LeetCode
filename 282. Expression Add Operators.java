public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num == null || num.length() == 0) return res;
        addOperatorsHelper(num, target, res, new StringBuilder(), 0, 0, 0);
        return res;
    }
    
    public void addOperatorsHelper(String num, int target, List<String> res,
                                   StringBuilder tmpRes, int pos, long result, long newAdded) {
        if(pos == num.length()) {
            if(result == target) res.add(tmpRes.toString());
            return;
        }

        int len = tmpRes.length();
        for(int i = pos; i < num.length(); i++) {
            // there is no digit behind '0' if '0' is the starting digit
            if(num.charAt(pos) == '0' && i != pos) break;
            long curr = Long.parseLong(num.substring(pos, i + 1));
            
            if(pos == 0) {
                // only add
                tmpRes.append(curr);
                addOperatorsHelper(num, target, res, tmpRes, i + 1, result + curr, curr);
                tmpRes.setLength(len);
            } else {
                // add
                tmpRes.append("+").append(curr);
                addOperatorsHelper(num, target, res, tmpRes, i + 1, result + curr, curr);
                tmpRes.setLength(len);

                // subtract
                tmpRes.append("-").append(curr);
                addOperatorsHelper(num, target, res, tmpRes, i + 1, result - curr, -curr);
                tmpRes.setLength(len);

                // multiple
                // like '227. Basic Calculator II'
                // if we want to multiple by the previous one, we need to subtract the previous one
                // and then do the calculation
                tmpRes.append("*").append(curr);
                addOperatorsHelper(num, target, res, tmpRes, i + 1, result - newAdded + newAdded * curr, newAdded * curr);
                tmpRes.setLength(len);
            }
        }
    }
}