public class Solution {
    public String countAndSay(int n) {
        if(n <= 1) return "1";
        if(n == 2) return "11";
        StringBuilder curr = new StringBuilder("11");

        while(n-- > 2) {
            StringBuilder next = new StringBuilder();
            int left = 0, right = 0;
            while(right < curr.length()) {
                while(right + 1 < curr.length() && curr.charAt(right) == curr.charAt(right + 1)) right++;

                next.append(right - left > 0 ? right - left + 1 : 1);
                next.append(curr.charAt(left));
                left = ++right;
            }
            curr = next;
        }
        return curr.toString();
    }
}