public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        if(words == null || words.length < 2) return res;
        
        // save all words in the map
        for(int i = 0; i < words.length; i++) map.put(words[i], i);
        
        // iterate the words
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j <= words[i].length(); j++) {
                String part1 = words[i].substring(0, j), part2 = words[i].substring(j);
                // check part1, part1 could be [0, words[i].length()]
                if(isPalindrome(part1)) {
                    String part2Reverse = new StringBuilder(part2).reverse().toString();
                    if(map.containsKey(part2Reverse) && map.get(part2Reverse) != i) {
                        res.add(new ArrayList<>(Arrays.asList(map.get(part2Reverse), i)));
                    }
                }
                
                // check part2, part2 could not be empty, so if part2 is empty, continue
                if(part2.length() == 0) continue;
                if(isPalindrome(part2)) {
                    String part1Reverse = new StringBuilder(part1).reverse().toString();
                    if(map.containsKey(part1Reverse) && map.get(part1Reverse) != i) {
                        res.add(new ArrayList<>(Arrays.asList(i, map.get(part1Reverse))));
                    }
                }
            }
        }
        return res;
    }
    
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}