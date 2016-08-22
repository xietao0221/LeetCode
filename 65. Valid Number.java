public class Solution {
    public boolean isNumber(String s) {
        boolean numberSeen = false, eSeen = false, dotSeen = false;
        s = s.trim();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '+' || c == '-') {
                if(i != 0 && s.charAt(i - 1) != 'e') return false;
            } else if(c == 'e') {
                if(eSeen || !numberSeen) return false;
                numberSeen = false;
                eSeen = true;
            } else if(c == '.') {
                if(dotSeen || eSeen) return false;
                dotSeen = true;
            } else if(c >= '0' && c <= '9') {
                numberSeen = true;
            } else {
                return false;
            }
        }
        return numberSeen;
    }
}