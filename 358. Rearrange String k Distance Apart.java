// PriorityQueue Solution
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


// https://discuss.leetcode.com/topic/48260/java-15ms-solution-with-two-auxiliary-array-o-n-time
/*
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
*/