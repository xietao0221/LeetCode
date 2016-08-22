public class Solution {
    public String countAndSay(int n) {
        if(n <= 1) return "1";
        if(n == 2) return "11";
        StringBuilder prev = new StringBuilder("11");
        
        while(n-- > 2) {
            StringBuilder curr = new StringBuilder();
            char target = prev.charAt(0);
            int count = 0;
            
            for(int i = 0; i < prev.length(); i++) {
                if(prev.charAt(i) == target) {
                    count++;
                } else {
                    curr.append(count);
                    curr.append(target);
                    count = 1;
                    target = prev.charAt(i);
                }
            }
            
            if(count != 0) {
                curr.append(count);
                curr.append(target);
                prev = curr;
            }
        }
        return prev.toString();
    }
}