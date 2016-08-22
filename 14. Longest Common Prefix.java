// unsort
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String pre = strs[0];
        for(int i = 1; i < strs.length; i++) {
            while(strs[i].indexOf(pre) != 0) pre = pre.substring(0, pre.length() - 1);
        }
        return pre;
    }
}

// sort
/*
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length-1];
        int i = 0;
        for(i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) break;
        }
        if(i == 0) return "";
        return str1.substring(0, i);
    }
}
*/