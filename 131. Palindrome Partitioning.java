public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        dfsSearching(s, 0, curr, result);
        return result;
    }
    
    public void dfsSearching(String str, int pos, List<String> curr, List<List<String>> result) {
        if(pos == str.length() && curr.size() != 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=pos; i<str.length(); i++) {
            if (checkPalindrome(str, pos, i)) {
                curr.add(str.substring(pos, i+1));
                dfsSearching(str, i+1, curr, result);
                curr.remove(curr.size() - 1);         // backtracking
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