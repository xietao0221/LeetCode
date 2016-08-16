public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>(), visited = new HashSet<>();
        int strLen = beginWord.length(), result = 1;
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            // always move one step from the set whose size is smaller
            if(beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            
            Set<String> nextBeginSet = new HashSet<>();
            for(String word: beginSet) {
                // for each word in the begin set, for each position, change to another character
                // and check if it is included in the dictionary
                char[] wordArray = word.toCharArray();
                for(int i=0; i<strLen; i++) {
                    for(char c='a'; c<='z'; c++) {
                        // modify and resotre
                        char oldChar = wordArray[i];
                        wordArray[i] = c;
                        String target = new String(wordArray);
                        wordArray[i] = oldChar;     // restore it
                        
                        if(endSet.contains(target)) return result + 1;
                        if(wordList.contains(target) && !visited.contains(target)) {
                            // don't need to backtracking, because BFS always has the shortest result
                            visited.add(target);
                            nextBeginSet.add(target);
                        }
                    }
                }
            }
            beginSet = nextBeginSet;
            result++;
        }
        return 0;
    }
}