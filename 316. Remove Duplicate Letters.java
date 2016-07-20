// https://discuss.leetcode.com/topic/31413/easy-to-understand-iterative-java-solution/2
public class Solution {
    public String removeDuplicateLetters(String s) {
        // find out the index where each character last appear
        char[] sArray = s.toCharArray();
        Map<Character, Integer> lastPosMap = new HashMap<>();
        for(int i=0; i<sArray.length; i++) lastPosMap.put(sArray[i], i);
        char[] res = new char[lastPosMap.size()];
        
        // begin and end is the range of searching
        int begin = 0, end = findMinPos(lastPosMap);
        for(int i=0; i<res.length; i++) {
            // update candidate if there is some char smaller than s[end]
            // lexicographical order is ensured this way
            char candidate = 'z' + 1;
            for(int k=begin; k<=end; k++) {
                if(lastPosMap.containsKey(sArray[k]) && sArray[k] < candidate) {    // important
                    candidate = sArray[k];
                    begin = k + 1;
                }
            }
            res[i] = candidate;
            lastPosMap.remove(candidate);       // ensure all chars are unique
            if(sArray[end] == candidate) end = findMinPos(lastPosMap);      // find the next anchor char
        }
        return new String(res);
    }
    
    public int findMinPos(Map<Character, Integer> lastPosMap) {
        if(lastPosMap.size() == 0) return -1;
        int minPos = Integer.MAX_VALUE;
        for(int pos: lastPosMap.values()) minPos = Math.min(minPos, pos);
        return minPos;
    }
}