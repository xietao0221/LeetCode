public class Solution {
    char[][] pairs = new char[][]{{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};
    int count = 0;
    
    public int strobogrammaticInRange(String low, String high) {
        for(int len = low.length(); len<=high.length(); len++) {
            dfs(low, high, 0, len-1, new char[len]);
        }
        return count;
    }
    
    public void dfs(String low, String high, int start, int end, char[] res) {
        if(start > end) {
            String tmp = new String(res);
            if((tmp.length() == low.length() && tmp.compareTo(low) < 0) || 
                (tmp.length() == high.length() && tmp.compareTo(high) > 0)) return;
            count++;
            return;
        }
        
        for(char[] pair: pairs) {
            res[start] = pair[0];
            res[end] = pair[1];
            if(res.length != 1 && res[0] == '0') continue;
            if(start < end || (start == end && pair[0] == pair[1])) {
                dfs(low, high, start+1, end-1, res);
            }
        }
    }
}