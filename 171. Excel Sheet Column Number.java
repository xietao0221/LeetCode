public class Solution {
    public int titleToNumber(String s) {
        char[] array = s.toCharArray();
        int num = 0;
        int factor = 1;
        for(int i = s.length() - 1; i >= 0; i--) {
            num += (array[i] - 'A' + 1) * factor;
            factor *= 26;
        }
        return num;
    }
}