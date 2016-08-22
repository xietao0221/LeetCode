// similar to '2. Add Two Numbers'
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] array1 = version1.split("\\."), array2 = version2.split("\\.");
        int len = Math.max(array1.length, array2.length);
        for(int i = 0; i < len; i++) {
            int num1 = i < array1.length ? Integer.parseInt(array1[i]) : 0;
            int num2 = i < array2.length ? Integer.parseInt(array2[i]) : 0;
            if(num1 < num2) return -1;
            else if(num1 > num2) return 1;
        }
        return 0;
    }
}