// BFS
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        return buildGraph(wordList, beginSet, endSet, false, 1);
    }

    private int buildGraph(Set<String> dict, Set<String> beginSet, Set<String> endSet, boolean flip, int count) {
        if (beginSet.isEmpty()) return 0;
        if (beginSet.size() > endSet.size()) return buildGraph(dict, endSet, beginSet, !flip, count);

        dict.removeAll(beginSet);
        dict.removeAll(endSet);
        Set<String> nextBeginSet = new HashSet<>();

        for (String word : beginSet) {
            for (int i = 0; i < word.length(); i++) {
                char[] wordArray = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    wordArray[i] = c;
                    String target = new String(wordArray);

                    if (endSet.contains(target)) return count + 1;
                    if (dict.contains(target)) nextBeginSet.add(target);
                }
            }
        }
        return buildGraph(dict, endSet, nextBeginSet, !flip, count + 1);
    }
}