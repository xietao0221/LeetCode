public class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() < 2) return s;
        String dict = "aeiouAEIOU";
        char[] sArray = s.toCharArray();
        int left = 0, right = sArray.length - 1;
        while(left < right) {
            while(left < right && dict.indexOf(sArray[left]) == -1) left++;
            while(left < right && dict.indexOf(sArray[right]) == -1) right--;
            if(left < right) {
                char tmp = sArray[left];
                sArray[left] = sArray[right];
                sArray[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(sArray);
    }
}