// https://discuss.leetcode.com/topic/28827/share-my-java-bfs-solution
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        boolean found = false;

        if(s == null) return res;
        
        // initialize the queue and visited
        queue.add(s);
        visited.add(s);

        // level n, remove n characters
        while(!queue.isEmpty()) {
            s = queue.poll();
            if(isValid(s)) {
                res.add(s);
                found = true;
            }
            // if found one solution, we don't need to remove more characters after, so continue for the next level
            // don't need to set it to 0 each round
            if(found) continue;

            // generate all possible strings
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) != '(' && s.charAt(i) != ')') continue;
                String modified = s.substring(0, i) + s.substring(i+1);

                // avoid duplicates
                if(!visited.contains(modified)) {
                    queue.offer(modified);
                    visited.add(modified);
                }
            }
        }
        return res;
    }
    
    public boolean isValid(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') count++;
            if(s.charAt(i) == ')') count--;
            if(count < 0) return false;
        }
        return count == 0;
    }
}