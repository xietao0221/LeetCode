/*
given a bag of chars, and a dictionary contains with many words,
find list of maximum length word which can be generated from the bag of chars respectively.
字符集中的字符不一定全用上

bag may contain duplicate characters.
The char in bag cannot be reused.
bag {a,p,l,e} cannot generate word ‘apple’.

case 1:
bag of chars
{u b e r d}
dict
{uber, red}
return
{uber}


case 2:
bag of chars
{a, p, p, l, e, o}
dict
{apple, people}
return
{apple}, because people need 2 char ‘e’, there is only 1 ‘e’ in the bag.


case 3:
bag of chars
{i, n, b, o, x, d, r, a, f, t, m, r, e}
dict
{inbox, draft, more,}
return
{inbox, draft}
*/
public class Solution {
    private int maxCount = Integer.MIN_VALUE;
    private List<String> res = new ArrayList<>();
    private StringBuilder tmpRes = new StringBuilder();
    private Map<Character, Integer> map = new HashMap<>();

    public List<String> findMaxWord(String letters, List<String> dict) {
        // build trie
        Trie trie = new Trie();
        Trie.TrieNode root = trie.root;
        for(String word: dict) trie.add(word);

        // build charSet
        for(char c: letters.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        dfs(map, root);
        return res;
    }

    private void dfs(Map<Character, Integer> map, Trie.TrieNode root) {
        if(root.isEnd) {
            if(tmpRes.length() == maxCount) {
                res.add(tmpRes.toString());
            } else if(tmpRes.length() > maxCount) {
                maxCount = tmpRes.length();
                res.clear();
                res.add(tmpRes.toString());
            }
        }

        int len = tmpRes.length();
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if(value > 0 && root.children[key - 'a'] != null) {
                tmpRes.append(key);
                map.put(key, map.get(key) - 1);
                dfs(map, root.children[key - 'a']);
                tmpRes.setLength(len);
                map.put(key, map.get(key) + 1);
            }
        }
    }

    class Trie {
        public TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void add(String word) {
            TrieNode curr = root;
            for(char c: word.toCharArray()) {
                if(curr.children[c - 'a'] == null) curr.children[c - 'a'] = new TrieNode();
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }

        class TrieNode {
            public boolean isEnd;
            public TrieNode[] children;

            public TrieNode() {
                isEnd = false;
                children = new TrieNode[26];
            }
        }
    }
}