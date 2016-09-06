// https://discuss.leetcode.com/topic/48260/java-15ms-solution-with-two-auxiliary-array-o-n-time
public class Solution {
    public String rearrangeString(String str, int k) {
        // count represents the count of each character
        // validPos represents the smallest position for each character
        int[] count = new int[26], validPos = new int[26];
        
        // record the count of each character
        for(char c: str.toCharArray()) count[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < str.length(); i++) {
            int candidate = findValidMaxRemaining(count, validPos, i);
            if(candidate == -1) return "";
            sb.append((char)('a' + candidate));
            
            // reset the count and validPos
            count[candidate]--;
            validPos[candidate] = i + k;
        }
        return sb.toString();
    }
    
    // find the valid(for position) character which has largest remaining count
    public int findValidMaxRemaining(int[] count, int[] validPos, int index) {
        int max = Integer.MIN_VALUE, candidate = -1;
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 0 && count[i] > max && index >= validPos[i]) {
                max = count[i];
                candidate = i;
            }
        }
        return candidate;
    }
}