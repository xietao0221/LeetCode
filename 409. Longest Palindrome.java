public class Solution {
    public int longestPalindrome(String s) {
        int[] charSet = new int[52];
        for(char c: s.toCharArray()) {
            if(c >= 'a' && c <= 'z') charSet[c - 'a']++;
            else charSet[c - 'A' + 26]++;
        }
        
        int evenCount = 0, oddCount = 0, oddMax = 0, oddNum = 0;
        for(int num: charSet) {
            if(num % 2 == 0) {
                evenCount += num;
            } else {
                oddCount += num;
                oddMax = Math.max(oddMax, num);
                oddNum++;
            }
        }
        return evenCount + (oddNum > 0 ? oddMax + (oddCount - oddMax - oddNum + 1) : 0);
    }
}