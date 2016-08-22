public class Solution {
    public String multiply(String num1, String num2) {
        char[] n1 = num1.toCharArray(), n2 = num2.toCharArray();
        int[] res = new int[n1.length + n2.length];
        for(int i = n1.length - 1; i >= 0; i--) {
            for(int j = n2.length - 1; j >= 0; j--) {
                res[i + j + 1] += (n1[i] - '0') * (n2[j] - '0');
            }
        }
        
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = res.length - 1; i >= 0; i--) {
            int sum = res[i] + carry;
            res[i] = sum % 10;
            carry = sum / 10;
            sb.append(res[i]);
        }
        sb = sb.reverse();
        
        while(sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}