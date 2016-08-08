public class ShiftString {
    public static void main(String[] args) {
        String str = "abcABCXYZ1234!";
        System.out.println(shiftString(str, 1));
    }

    static String shiftString(String str, int k) {
        char[] s = str.toCharArray();
        k = k % 26;
        for(int i=0; i<s.length; i++) {
            if(s[i]>='a' && s[i]<='z') {
                s[i] = (char) ('a' + (s[i] - 'a' + k) % 26);
            }
            if(s[i]>='A' && s[i]<='Z') {
                s[i] = (char) ('A' + (s[i] - 'A' + k) % 26);
            }
        }
        return new String(s);
    }
}