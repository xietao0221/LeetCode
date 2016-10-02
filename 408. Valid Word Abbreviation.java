public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        char[] wordArray = word.toCharArray(), abbrArray = abbr.toCharArray();
        int index1 = 0;
        
        for(int index2 = 0; index2 < abbrArray.length; index2++) {
            if(index1 >= wordArray.length) return false;
            
            char c = abbrArray[index2];
            if(c >= '0' && c <= '9') {
                int left = index2;
                if(abbrArray[left] == '0') return false;
                
                while(index2 < abbrArray.length - 1 && 
                    abbrArray[index2 + 1] >= '0' && abbrArray[index2 + 1] <= '9') index2++;
                index1 += Integer.parseInt(abbr.substring(left, index2 + 1));
            } else if(c >= 'a' && c <= 'z') {
                if(wordArray[index1++] != abbrArray[index2]) return false;
            }
        }
        return index1 == wordArray.length;
    }
}