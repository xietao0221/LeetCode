public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1); map.put('V', 5); map.put('X', 10); map.put('L', 50); 
        map.put('C', 100); map.put('D', 500); map.put('M', 1000);
        
        int count = 0;
        char first, second;
        for(int i = 0; i < s.length(); i++) {
            first = s.charAt(i);
            if(i + 1 < s.length()) {
                second = s.charAt(i + 1);
                if((first == 'I' && (second == 'V' || second == 'X')) || (first == 'X' && (second == 'L' || second == 'C'))
                || (first == 'C' && (second == 'D' || second == 'M'))) {
                    count += map.get(second) - map.get(first);
                    i++;
                } else {
                    count += map.get(first);
                }
            } else {
                count += map.get(first);
            }
        }
        return count;
    }
}