// use int[]
public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] letters = new int[256];
        int oddCount = 0;
        for(char c: s.toCharArray()) {
            oddCount += ++letters[c] % 2 != 0 ? 1 : -1;
        }
        return oddCount <= 1;
    }
}

// use hash set
/*
public class Solution {
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))) set.remove(s.charAt(i));
            else set.add(s.charAt(i));
        }
        return set.size() <= 1;
    }
}
*/