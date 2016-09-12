// https://discuss.leetcode.com/topic/28855/java-bfs-solution-16ms-avoid-generating-duplicate-strings/2
// faster BFS
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if(isValid(s)) return new ArrayList<>(Arrays.asList(s));

        boolean found = false;
        List<String> res = new ArrayList<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(s, 0, ')'));

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                Tuple curr = queue.poll();
                
                // always begin with the position left by last round
                for(int i = curr.start; i < curr.string.length(); i++) {
                    char c = curr.string.charAt(i);
                    
                    // (1) if not parentheses
                    // (2) if these two are the same, we only remove the first one
                    // (3) if the last removed character is '(', we cannot remove a ')', which is not optimal
                    if((c != '(' && c != ')') ||
                            (i > curr.start && curr.string.charAt(i - 1) == c) ||
                            (curr.lastRemoved == '(' && c == ')')) continue;

                    String modified = curr.string.substring(0, i) + curr.string.substring(i + 1);

                    if(isValid(modified)) {
                        res.add(modified);
                        found = true;
                    } else {
                        queue.offer(new Tuple(modified, i, c));
                    }
                }
            }
            if(found) break;
        }
        return res;
    }

    private boolean isValid(String s) {
        char[] sArray = s.toCharArray();
        int count = 0;
        for(int i = 0; i < sArray.length; i++) {
            if(sArray[i] == '(') count++;
            if(sArray[i] == ')') count--;
            if(count < 0) return false;
        }
        return count == 0;
    }

    class Tuple {
        public String string;
        public int start;
        public char lastRemoved;

        public Tuple(String string, int start, char lastRemoved) {
            this.string = string;
            this.start = start;
            this.lastRemoved = lastRemoved;
        }
    }
}

// BFS
/*
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
            int size = queue.size();
            while(size-- > 0) {
                s = queue.poll();
                if(isValid(s)) {
                    res.add(s);
                    found = true;
                }
                
                // generate all possible strings
                for(int i = 0; i < s.length(); i++) {
                    if(s.charAt(i) != '(' && s.charAt(i) != ')') continue;
                    String modified = s.substring(0, i) + s.substring(i + 1);
    
                    // avoid duplicates
                    if(!visited.contains(modified)) {
                        queue.offer(modified);
                        visited.add(modified);
                    }
                }    
            }
            if(found) break;
        }
        return res;
    }
    
    private boolean isValid(String s) {
        char[] sArray = s.toCharArray();
        int count = 0;
        for(int i = 0; i < sArray.length; i++) {
            if(sArray[i] == '(') count++;
            if(sArray[i] == ')') count--;
            if(count < 0) return false;
        }
        return count == 0;
    }
}
*/