// https://leetcode.com/discuss/72701/here-10-line-template-that-can-solve-most-substring-problems
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>(), currMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int len = words[0].length(), size = words.length, count = 0, begin = 0, end = 0;
        if(size == 0 || s.length() < len * size) return res;
        
        // store all word in map
        for(String word: words) map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);

        // all words have the same length, so there are words[0].length() times rounds,
        // for each rounds we use words[0].length() as the smallest unit to increase the index
        // similar to do '76. Minimum Window Substring' question multiple times
        // but for this question, the element is words not character, use hash map is a better idea
        for(int i = 0; i < len; i++) {
            // initialization
            count = 0;
            begin = i;
            end = begin;
            
            // '76. Minimum Window Substring'
            while(end <= s.length() - len) {
                String target = s.substring(end, end + len);
                end += len;
                if(map.containsKey(target)) {
                    currMap.put(target, currMap.containsKey(target) ? currMap.get(target) + 1 : 1);

                    // put one word into window
                    if(currMap.get(target) <= map.get(target)) {
                        count++;
                    } else {
                        // if there are duplicates in the window, we should shrink the window until duplicates gone
                        while(currMap.get(target) > map.get(target)) {
                            String removed = s.substring(begin, begin + len);
                            begin += len;
                            currMap.put(removed, currMap.get(removed) - 1);
                            if(currMap.get(removed) < map.get(removed)) count--;
                        }    
                    }
                    
                    // if all words are in the window, add index of begin into list
                    // and then shrink the window by removing one left-most word
                    if(count == size) {
                        res.add(begin);
                        String removed = s.substring(begin, begin + len);
                        begin += len;
                        currMap.put(removed, currMap.get(removed) - 1);
                        count--;    // do not need to check (currMap.get(removed) < map.get(removed)), because it must be
                    }
                } else {
                    // end this substring search immediately, and set index of begin as the one of end
                    count = 0;
                    currMap.clear();
                    begin = end;
                }
            }
            currMap.clear();
        }
        return res;
    }
}