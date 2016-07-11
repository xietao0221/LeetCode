public class Solution {
    // hash map
    /*
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('6','9');
        map.put('9','6');
        map.put('1','1');
        map.put('8','8');
        map.put('0','0');
        
        for(int i=0; i<=num.length()/2; i++) {
            if(!map.containsKey(num.charAt(i))) return false;
            if(!map.get(num.charAt(i)).equals(num.charAt(num.length()-1-i))) return false;
        }
        return true;
    }
    */
    
    // array
    public boolean isStrobogrammatic(String num) {
        Character[] map = new Character[]{'0','1',null,null,null,null,'9',null,'8','6'};
        char[] numArray = num.toCharArray();
        int start = 0, end = numArray.length - 1;
        while(start <= end) {
            if(map[numArray[start] - '0'] == null ||  map[numArray[start] - '0'] != numArray[end]) return false;
            start++;
            end--;
        }
        return true;
    }
}