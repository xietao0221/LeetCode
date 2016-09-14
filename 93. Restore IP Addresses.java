public class Solution {
    public List<String> restoreIpAddresses(String s) {
        if(s == null || s.length() < 4) return new ArrayList<>();
        
        List<String> res = new ArrayList<>();
        StringBuilder tmpRes = new StringBuilder();
        search(s, 0, 0, tmpRes, res);
        return res;
    }
    
    public void search(String s, int index, int count, StringBuilder tmpRes, List<String> res) {
        if(count == 4) {
            if(index == s.length()) res.add(tmpRes.toString().substring(0, tmpRes.length() - 1));
            return;
        }
        
        for(int i = 1; i <= 3 && index + i <= s.length(); i++) {
            int num = Integer.parseInt(s.substring(index, index + i));
            
            // if num is invalid, return immediately, because the rest cannot be valid then
            if (num > 255 || (i > 1 && num <= 9)) return;
            
            int len = tmpRes.length();
            tmpRes.append(num).append(".");
            
            search(s, index + i, count + 1, tmpRes, res);
            
            tmpRes.setLength(len);          // backtracking
        }
    }
}