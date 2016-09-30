// BFS
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        List<String> tmpRes = new ArrayList<>(Arrays.asList(beginWord));
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        // if build success, generate the path
        if(buildGraph(wordList, beginSet, endSet, graph, false)) outputPath(beginWord, endWord, graph, res, tmpRes);
        return res;
    }

    private boolean buildGraph(Set<String> wordList, Set<String> beginSet, Set<String> endSet,
                               Map<String, List<String>> graph, boolean flip) {
        if (beginSet.isEmpty()) return false;
        if (beginSet.size() > endSet.size()) return buildGraph(wordList, endSet, beginSet, graph, !flip);

        wordList.removeAll(beginSet);
        wordList.removeAll(endSet);
        boolean done = false;
        Set<String> nextBeginSet = new HashSet<>();

        for (String word : beginSet) {
            for (int i = 0; i < word.length(); i++) {
                char[] wordArray = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    wordArray[i] = c;
                    String target = new String(wordArray);

                    // if the current beginSet is the endSet actually, we need to flip the (key, value)
                    String key = flip ? target : word, val = flip ? word : target;
                    if (endSet.contains(target)) {
                        done = true;
                        if(!graph.containsKey(key)) graph.put(key, new ArrayList<>());
                        graph.get(key).add(val);
                    } else if (wordList.contains(target)) {
                        nextBeginSet.add(target);
                        if(!graph.containsKey(key)) graph.put(key, new ArrayList<>());
                        graph.get(key).add(val);
                    }
                }
            }
        }
        return done || buildGraph(wordList, nextBeginSet, endSet, graph, flip);
    }

    private void outputPath(String start, String end, Map<String, List<String>> graph,
                            List<List<String>> res, List<String> tmpRes) {
        if (start.equals(end)) {
            res.add(new ArrayList<>(tmpRes));
            return;
        }

        if (!graph.containsKey(start)) return;
        for (String word : graph.get(start)) {
            tmpRes.add(word);
            outputPath(word, end, graph, res, tmpRes);
            tmpRes.remove(tmpRes.size() - 1);
        }
    }
}