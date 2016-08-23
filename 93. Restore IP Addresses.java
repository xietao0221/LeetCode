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
            if(index == s.length()) res.add(tmpRes.toString());
            return;
        }
        
        for(int i = 1; i <= 3 && i + index <= s.length(); i++) {
            int num = Integer.parseInt(s.substring(index, index + i));
            
            // if num is invalid, return immediately, because the rest cannot be valid then
            if (num >= 256 || (i > 1 && num <= 9)) return;
            
            int len = tmpRes.length();      // save the previous length
            if(count == 0) tmpRes.append(num);
            else tmpRes.append(".").append(num);
            
            search(s, index + i, count + 1, tmpRes, res);
            
            tmpRes.setLength(len);          // backtracking
        }
    }
}