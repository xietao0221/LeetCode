public class Solution {
    public String addStrings(String num1, String num2) {
        char[] num1Array = num1.toCharArray(), num2Array = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int carry = 0, index1 = num1Array.length - 1, index2 = num2Array.length - 1;
        while(index1 >= 0 || index2 >= 0 || carry > 0) {
            int sum = (index1 >= 0 ? num1Array[index1] - '0' : 0) + (index2 >= 0 ? num2Array[index2] - '0' : 0) + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            index1--;
            index2--;
        }
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}