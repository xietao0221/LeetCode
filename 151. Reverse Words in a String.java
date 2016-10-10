// use extra space
public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";
        
        String[] array = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        for(int i = array.length - 1; i >= 0; i--) {
            sb.append(array[i]).append(" ");
        }
        if(sb.length() > 0) sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}

// inplace
/*
public class Solution {
    public String reverseWords(String s) {
        char[] array = s.trim().replaceAll(" +", " ").toCharArray();
        reverseString(array, 0, array.length - 1);
        
        int start = 0, end = 0;
        while(end < array.length) {
            while(start < array.length && array[start] == ' ') start++;
            end = start;
            while(end < array.length && array[end] != ' ') end++;
            end--;
            
            reverseString(array, start, end);
            start = ++end;
        }
        return new String(array);
    }
    
    public void reverseString(char[] array, int start, int end) {
        while(start < end) {
            char tmp = array[start];
            array[start++] = array[end];
            array[end--] = tmp;
        }
    }
}
*/