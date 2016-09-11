public class Solution {
    public String func(String s) {
        if(s.length() < 2) return s;

        char[] sArray = s.toCharArray();
        char maxChar = 'a';
        for(char c: sArray) {
            if(c > maxChar) maxChar = c;
        }

        List<String> list = new ArrayList<>();
        for(int i = 0; i < sArray.length; i++) {
            if(sArray[i] == maxChar) list.add(s.substring(i));
        }

        Collections.sort(list);
        return list.get(list.size() - 1);
    }
}