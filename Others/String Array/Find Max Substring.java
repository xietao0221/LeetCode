/*
Given a string containing only characters 'a' and 'b', and also given an integer M.
Return the max length of substring you can form such that all the characters in the substring are same,
provided you can change at most M characters.
*/
public class Solution {
    public String maxSubstring(String s, int m) {
        if(s == null || s.length() == 0) return null;

        char[] sArray = s.toCharArray();
        int left = 0, right = 0, countA = 0, countB = 0, resCount = 0, resLeft = 0, resRight = 0;
        while(right < sArray.length) {
            if(sArray[right++] == 'a') countA++;
            else countB++;

            if(countA == m || countB == m) {
                if(right - left > resCount) {
                    resCount = right - left;
                    resLeft = left;
                    resRight = right;
                }

                while(left < sArray.length && countA >= m && countB >= m) {
                    if(sArray[left++] == 'a') countA--;
                    else countB--;
                }
            }
        }
        return resCount == 0 ? s : s.substring(resLeft, resRight);
    }
}