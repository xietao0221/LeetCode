public class Solution {
    public String bigDouble(String a, String b) {
        String[] aArray = a.split("\\."), bArray = b.split("\\.");
        StringBuilder part1 = new StringBuilder(), part2 = new StringBuilder();

        // calculate decimal part
        char[] num1 = aArray[1].toCharArray(), num2 = bArray[1].toCharArray();
        int index = Math.max(num1.length, num2.length) - 1, carry = 0;
        while(index >= 0) {
            int n1 = index < num1.length ? num1[index] - '0' : 0, n2 = index < num2.length ? num2[index] - '0' : 0;
            int sum = n1 + n2 + carry;
            part2.insert(0, sum % 10);
            carry = sum > 9 ? 1 : 0;
            index--;
        }

        // calculate integer part
        num1 = aArray[0].toCharArray();
        num2 = bArray[0].toCharArray();
        int index1 = num1.length - 1, index2 = num2.length - 1;
        while(index1 >= 0 || index2 >= 0 || carry != 0) {
            int n1 = index1 >= 0 ? num1[index1] - '0' : 0, n2 = index2 >= 0 ? num2[index2] - '0' : 0;
            int sum = n1 + n2 + carry;
            part1.insert(0, sum % 10);
            carry = sum > 9 ? 1 : 0;
            index1--;
            index2--;
        }
        part1.append(".").append(part2);
        return part1.toString();
    }
}