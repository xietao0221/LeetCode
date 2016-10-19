public class Solution {
    private List<List<String>> res = new ArrayList<>();
    private List<String> tmpRes = new ArrayList<>();

    public List<List<String>> wordSquares(String[] words) {
        Trie trie = new Trie(words);
        dfs(trie, words[0].length());
        return res;
    }

    private void dfs(Trie trie, int wordLen) {
        if(tmpRes.size() == wordLen) {
            res.add(new ArrayList<>(tmpRes));
            return;
        }

        int index = tmpRes.size();
        StringBuilder prefix = new StringBuilder();
        for(String word: tmpRes) prefix.append(word.charAt(index));
        for(String tmp: trie.wordWithPrefix(prefix.toString())) {
            tmpRes.add(tmp);
            dfs(trie, wordLen);
            tmpRes.remove(tmpRes.size() - 1);
        }
    }

    class Trie {
        TrieNode root = new TrieNode();

        public Trie(String[] words) {
            for(String word: words) {
                TrieNode curr = root;
                for(char c: word.toCharArray()) {
                    if(curr.children[c - 'a'] == null) curr.children[c - 'a'] = new TrieNode();
                    curr.words.add(word);
                    curr = curr.children[c - 'a'];
                }
            }
        }

        public List<String> wordWithPrefix(String prefix) {
            List<String> res = new ArrayList<>();
            TrieNode curr = root;
            for(char c: prefix.toCharArray()) {
                if(curr.children[c - 'a'] == null) return res;
                curr = curr.children[c - 'a'];
            }
            res.addAll(curr.words);
            return res;
        }

        class TrieNode {
            public List<String> words = new ArrayList<>();
            public TrieNode[] children = new TrieNode[26];
        }
    }
}