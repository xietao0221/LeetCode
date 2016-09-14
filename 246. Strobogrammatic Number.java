// array
public class Solution {
    public boolean isStrobogrammatic(String num) {
        Character[] map = new Character[]{'0', '1', null, null, null, null, '9', null, '8', '6'};
        char[] numArray = num.toCharArray();
        int left = 0, right = numArray.length - 1;
        while(left <= right) {
            if(map[numArray[left] - '0'] == null ||  map[numArray[left] - '0'] != numArray[right]) return false;
            left++;
            right--;
        }
        return true;
    }
}

// hash map
/*
public class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        char[] numArray = num.toCharArray();
        map.put('6','9');
        map.put('9','6');
        map.put('1','1');
        map.put('8','8');
        map.put('0','0');
        
        for(int i = 0; i <= numArray.length / 2; i++) {
            if(!map.containsKey(numArray[i])) return false;
            if(map.get(numArray[i]) != numArray[numArray.length - 1 - i]) return false;
        }
        return true;
    }
}
*/