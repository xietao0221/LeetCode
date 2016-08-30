public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> tmpRes = new ArrayList<>();
        dfsSearching(s, 0, tmpRes, res);
        return res;
    }
    
    public void dfsSearching(String str, int pos, List<String> tmpRes, List<List<String>> res) {
        if(pos == str.length() && tmpRes.size() != 0) {
            res.add(new ArrayList<>(tmpRes));
            return;
        }
        
        for(int i = pos; i < str.length(); i++) {
            if (checkPalindrome(str, pos, i)) {
                tmpRes.add(str.substring(pos, i + 1));
                dfsSearching(str, i + 1, tmpRes, res);
                tmpRes.remove(tmpRes.size() - 1);         // backtracking
            }
        }
    }
    
    public boolean checkPalindrome(String str, int left, int right) {
        if(left == right) return true;
        while(left < right) {
            if(str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }
}