public class Solution {
    public String decodeString(String s) {
        char[] sArray = s.toCharArray();
        Stack<StringNum> stack = new Stack<>();
        StringNum curr = new StringNum();
        int num = 0;

        for(int i = 0; i < sArray.length; i++) {
            if(Character.isDigit(sArray[i])) {
                int start = i;
                while(i + 1 < sArray.length && Character.isDigit(sArray[i + 1])) i++;
                curr.num = Integer.parseInt(s.substring(start, i + 1));
            } else if(Character.isLetter(sArray[i])) {
                int start = i;
                while(i + 1 < sArray.length && Character.isLetter(sArray[i + 1])) i++;
                curr.word.append(s.substring(start, i + 1));
            } else if(sArray[i] == '[') {
                stack.push(curr);
                curr = new StringNum();
            } else if(sArray[i] == ']') {
                String post = curr.word.toString();
                curr = stack.pop();
                for(int j = 0; j < curr.num; j++) curr.word.append(post);
            }
        }
        return curr.word.toString();
    }

    class StringNum {
        public StringBuilder word = new StringBuilder();
        int num = 0;
    }
}