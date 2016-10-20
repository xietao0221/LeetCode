public class Solution {
    public String minAbbreviation(String target, String[] dictionary) {
        if(dictionary == null || dictionary.length == 0) return target.length() + "";
        
        Trie trie = new Trie(dictionary);
        List<String> res = new ArrayList<>();
        generateAbbr(res, new StringBuilder(), target.toCharArray(), 0, 0);
        Collections.sort(res, (a, b) -> (a.length() - b.length()));
        for(String s: res) {
            if(!trie.search(s, trie.root, 0, 0)) return s;
        }
        return "";
    }

    private void generateAbbr(List<String> res, StringBuilder tmpRes, char[] wordArray, int pos, int numCount) {
        if(pos == wordArray.length) {
            if(numCount > 0) tmpRes.append(numCount);
            res.add(tmpRes.toString());
            return;
        }

        // use number
        int len = tmpRes.length();
        generateAbbr(res, tmpRes, wordArray, pos + 1, numCount + 1);
        tmpRes.setLength(len);              // backtracking

        // use character
        len = tmpRes.length();
        if(numCount > 0) {
            tmpRes.append(numCount).append(wordArray[pos]);
            generateAbbr(res, tmpRes, wordArray, pos + 1, 0);
        } else {
            tmpRes.append(wordArray[pos]);
            generateAbbr(res, tmpRes, wordArray, pos + 1, 0);
        }
        tmpRes.setLength(len);              // backtracking
    }

    class Trie {
        TrieNode root = new TrieNode();

        public Trie(String[] words) {
            for(String word: words) {
                TrieNode curr = root;
                for(char c: word.toCharArray()) {
                    if(curr.children[c - 'a'] == null) curr.children[c - 'a'] = new TrieNode();
                    curr = curr.children[c - 'a'];
                }
                curr.isEnd = true;
            }
        }

        public boolean search(String target, TrieNode root, int pos, int loop) {
            if(root == null) return false;

            if(loop != 0) {
                for(int i = 0; i < 26; i++) {
                    if(root.children[i] != null) {
                        if(search(target, root.children[i], pos, loop - 1)) return true;
                    }
                }
                return false;
            }

            if(pos == target.length()) return root.isEnd;

            char c = target.charAt(pos);
            if(c >= '0' && c <= '9') {
                int count = c - '0';
                while(pos + 1 < target.length() && target.charAt(pos + 1) >= '0' && target.charAt(pos + 1) <= '9') {
                    count = 10 * count + (target.charAt(++pos) - '0');
                }
                return search(target, root, pos + 1, count);
            } else {
                return search(target, root.children[c - 'a'], pos + 1, loop);
            }
        }

        class TrieNode {
            public boolean isEnd = false;
            public TrieNode[] children = new TrieNode[26];
        }
    }
}