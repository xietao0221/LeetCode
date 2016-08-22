public class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right=s.length() - 1;
        char[] sArray = s.toLowerCase().toCharArray();
        while(left < right) {
            while(left < s.length() && !Character.isLetter(sArray[left]) && !Character.isDigit(sArray[left])) left++;
            while(right >= 0 && !Character.isLetter(sArray[right]) && !Character.isDigit(sArray[right])) right--;
            if(left < right && sArray[left] != sArray[right]) return false;
            left++;
            right--;
        }
        return true;
    }
}