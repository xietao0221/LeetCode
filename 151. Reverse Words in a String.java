public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        char[] array = s.trim().toCharArray();
        reverseString(array, 0, array.length - 1);
        
        int start = 0, end = 0;
        while(end < array.length) {
            while(start < array.length && array[start] == ' ') start++;
            end = start;
            while(end < array.length && array[end] != ' ') end++;
            end--;
            
            reverseString(array, start, end);
            for(int i = start; i <= end; i++) sb.append(array[i]);
            sb.append(" ");
            
            start = ++end;
        }
        if(sb.length() > 0) sb.setLength(sb.length() - 1);
        return sb.toString();
    }
    
    public void reverseString(char[] array, int start, int end) {
        while(start < end) {
            char tmp = array[start];
            array[start++] = array[end];
            array[end--] = tmp;
        }
    }
}