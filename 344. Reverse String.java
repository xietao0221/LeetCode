public class Solution {
    public String reverseString(String s) {
        if(s == null || s.length() == 0) return s;
        int left = 0, right = s.length() - 1;
        char[] array = s.toCharArray();
        while(left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
        return new String(array);
    }
}