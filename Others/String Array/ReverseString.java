public class ReverseString {
    public static void main(String[] args) {
        String str = "I   jij    ii";
        System.out.println(reverseString(str));
    }

    static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--) {
            sb.append(str.charAt(i));
        }

        int start = 0, end = 0;
        while(end < sb.length()) {
            while(sb.charAt(end) != ' ' && end < sb.length()-1) end++;

            if(end < sb.length() && sb.charAt(end) == ' ') {
                for(int i=0; i<=(end-1-start)/2; i++) {
                    char tmp = sb.charAt(start + i);
                    sb.setCharAt(start + i, sb.charAt(end-1 - i));
                    sb.setCharAt(end-1 - i, tmp);
                }
                end++;
                start = end;
            } else {
                break;
            }
        }
        return sb.toString();
    }
}