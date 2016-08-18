// https://leetcode.com/discuss/72701/here-10-line-template-that-can-solve-most-substring-problems
// http://www.rudy-yuan.net/archives/185/
public class Solution {
    public String minWindow(String s, String t) {
        int[] charSet = new int[128];       // the character set of String t
        int begin = 0, end = 0, head = 0, minWindowSize = Integer.MAX_VALUE, count = t.length();
        
        // save all characters of t in the set
        for(int i = 0; i < t.length(); i++) charSet[t.charAt(i)]++;

        while(end < s.length()) {
            // move right bound of window, put characters in the window
            // If char in s exists in t(the set value > 0), decrease counter; 
            // this positive value ensures window begins to enclose a new valid char of t.
            if(charSet[s.charAt(end++)]-- > 0) count--;

            // when all characters of t are all in the window, we find a valid window
            while(count == 0) {
                // check the new window size
                // end is the index one larger than right bound of window, so end-begin is the window size
                if(end - begin < minWindowSize) {
                    head = begin;
                    minWindowSize = end - begin;
                }

                // move left bound of window, put characters out of the window
                // if the char of t occurs, the x++ could be 0; otherwise is negative
                if(++charSet[s.charAt(begin++)] > 0) count++;
            }
        }
        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(head, head + minWindowSize);
    }
}