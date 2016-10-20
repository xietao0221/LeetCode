// https://discuss.leetcode.com/topic/62455/21ms-18-lines-java-solution
public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int index = 0, len = s.length();
        for(int i = 0; i < rows; i++) {
            index += cols;
            if(s.charAt(index % len) == ' ') {
                index++;
            } else {
                while(index > 0 && s.charAt((index - 1) % len) != ' ') index--;
            }
        }
        return index / len;
    }
}

// brute force, result in TLE
/*
public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int index = 0, res = 0;
        for(int i = 0; i < rows; i++) {
            int len = -1, count = 0;
            while(true) {
                len += 1 + sentence[index].length();
                if(len > cols) break;
                index = (index + 1) % sentence.length;
                count++;
            }
            res += count;
        }
        return res / sentence.length;
    }
}
*/