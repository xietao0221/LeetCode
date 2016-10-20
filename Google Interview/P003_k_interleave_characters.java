/*
3. (面经中看到多次)给一个string 比如aaabb，
重新排列这个string的character让相同的character不相邻

follow up 相同的character相距至少为k (已解决，用heap+queue)
a. 另一种问法：给一个String[] array, 和任意一个移动的window size k，
对array里的元素位置进行改变，使得window里的元素不重复. 要efficient的解法。

相距定义为 j - i >= k
*/

import java.util.*;
public class Solution {
    public String rearrangeString(String str, int k) {
        // live is a priority queue which polls out the tuple whose remaining count is the max
        PriorityQueue<Tuple> live = new PriorityQueue<>();
        int[] charSet = new int[26];
        for(char c: str.toCharArray()) charSet[c - 'a']++;
        for(int i = 0; i < 26; i++) {
            if(charSet[i] != 0) live.offer(new Tuple((char)(i + 'a'), charSet[i], 0));
        }
        
        // dead is the queue which keeps the tuple whose validPos is greater than (i + k) 
        Queue<Tuple> dead = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            // move all valid tuple into live
            while(!dead.isEmpty() && dead.peek().validPos <= i) live.offer(dead.poll());
            if(live.isEmpty()) return "";
            
            // this curr is valid, append it to final result, and move this tuple into dead queue
            Tuple curr = live.poll();
            sb.append(curr.ch);
            if(--curr.count > 0) {
                curr.validPos = i + k;
                dead.offer(curr);
            }
        }
        return sb.toString();
    }

    class Tuple implements Comparable<Tuple> {
        public int count, validPos;
        public char ch;

        public Tuple(char ch, int count, int validPos) {
            this.ch = ch;
            this.count = count;
            this.validPos = validPos;
        }

        public int compareTo(Tuple o) {
            return o.count - this.count;
        }
    }
}