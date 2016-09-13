public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder tmpRes = new StringBuilder();
        generateParenthesisHelper(res, tmpRes, n, n);
        return res;
    }
    
    public void generateParenthesisHelper(List<String> res, StringBuilder tmpRes, int leftRem, int rightRem) {
        // the remaining number of ')' cannot be smaller than the one of ')' => '())' is invalid
        if(leftRem < 0 || rightRem < leftRem) return;  
        
        // success
        if(leftRem == 0 && rightRem == 0) {
            res.add(tmpRes.toString());
            return;
        }
        
        if(leftRem > 0) {
            tmpRes.append("(");
            generateParenthesisHelper(res, tmpRes, leftRem - 1, rightRem);
            tmpRes.setLength(tmpRes.length() - 1);
        }
        
        if(rightRem > leftRem) {
            tmpRes.append(")");
            generateParenthesisHelper(res, tmpRes, leftRem, rightRem - 1);
            tmpRes.setLength(tmpRes.length() - 1);
        }
    }
}