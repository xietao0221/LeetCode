// similar to '2. Add Two Numbers'
public class Solution {
    public String addBinary(String a, String b) {
        char[] aArray = a.toCharArray(), bArray = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int indexA = aArray.length - 1, indexB = bArray.length - 1, carry = 0;
        
        while(indexA >= 0 || indexB >= 0) {
            int tempA = indexA >= 0 ? aArray[indexA] - '0' : 0;
            int tempB = indexB >= 0 ? bArray[indexB] - '0' : 0;
            int tempSum = (tempA + tempB + carry);
            sb.append(tempSum % 2);
            carry = tempSum / 2;
            indexA--;
            indexB--;
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}