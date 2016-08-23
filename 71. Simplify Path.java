public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return null;
        
        Stack<String> stack = new Stack<>();
        String[] pathArray = path.split("/");
        
        for(String file: pathArray) {
            if(file.length() == 0) continue;
            if(file.equals("..") && !stack.isEmpty()) stack.pop();
            if(!file.equals("..") && !file.equals(".")) stack.push(file);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()) sb.insert(0, "/" + stack.pop().toString());
        return sb.length() == 0 ? "/" : sb.toString();
    }
}