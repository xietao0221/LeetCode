// use stack
public class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] array = preorder.split(",");
        
        for(String curr: array) {
            // when you already have 'X,#', and the oncoming one is '#', you pop out 'X,#' and push into '#'
            // which means you transform 'X,#,#' to '#'
            // notices: you have to ensure there is at least one thing before 'X,#'
            while(curr.equals("#") && (!stack.isEmpty() && stack.peek().equals("#"))) {
                stack.pop();                        // pop out '#'
                if(stack.isEmpty()) return false;   // ensure there is at least one thing before 'X'
                stack.pop();                        // pop out 'X'
            }
            stack.push(curr);                       // push the current one: '#' or 'X'
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}


// use indegree and outdegree
// if the curr node is NOT NULL, diff += 1, because 1 indgree(-1) and 2 outdegree(+2)
// if the curr node is NULL, diff -= 1, because only 1 ingree(-1) and 0 outdegree(+0)
/*
public class Solution {
    public boolean isValidSerialization(String preorder) {
        int diff = 1;
        for(String curr: preorder.split(",")) {
            if(diff <= 0) return false;
            if(curr.equals("#")) diff -= 1;
            else diff += 1;
        }
        return diff == 0;
    }
}
*/