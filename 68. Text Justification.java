public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int start = 0, end = 0;
        
        while(end < words.length) {
            // calculate the number of words you put in this line
            // insert a white space before a word, but the first word don't need to, so set len to -1
            int len = -1;
            while(end < words.length && len + words[end].length() + 1 <= maxWidth) {
                len += words[end++].length() + 1;
            }
            
            // calculate how many white space for every interval
            int base = 1, extra = 0;
            if(end != start + 1 && end != words.length) {
                base = (maxWidth - len) / (end - start - 1) + 1;
                extra = (maxWidth - len) % (end - start - 1);
            }

            // output this line
            StringBuilder sb = new StringBuilder();
            int strLen = 0;
            while(start < end) {
                sb.append(words[start++]);
                strLen += words[start-1].length();
                if(strLen < maxWidth) {
                    sb = fillSpace(sb, base);
                    strLen += base;
                }
                if(extra-- > 0) {
                    sb.append(' ');
                    strLen++;
                }
            }

            while(strLen++ < maxWidth) sb.append(' ');
            res.add(sb.toString());
        }
        return res;
    }
    
    private StringBuilder fillSpace(StringBuilder sb, int num) {
        while(num-- > 0) sb.append(' ');
        return sb;
    }
}