// use pointer
public class Solution {
    public int lengthOfLastWord(String s) {
        char[] sArray = s.trim().toCharArray();
        int index = sArray.length - 1;
        while(index >= 0 && sArray[index] != ' ') index--;
        return sArray.length - 1 - index;
    }
}

// use split
/*
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null) return 0;
        String[] sArray = s.trim().split(" ");
        return sArray.length == 0 ? 0 : sArray[sArray.length - 1].length();
    }
}
*/