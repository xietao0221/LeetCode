public class WordDictionary {
    private TrieNode root = new TrieNode();
    private Map<String, Boolean> memo = new HashMap<>();
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        if(memo.containsKey(word) && memo.get(word)) return;
        TrieNode tmp = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(tmp.children[c - 'a'] == null) tmp.children[c - 'a'] = new TrieNode();
            tmp = tmp.children[c - 'a'];
        }
        tmp.isEnd = true;
        memo.put(word, true);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word == null || word.length() == 0) return false;
        if(memo.containsKey(word)) return memo.get(word);
        
        if(searchHelper(word, 0, root)) {
            // only update map if the word is searched, because next time this word may be added
            memo.put(word, true);
            return true;
        } else {
            return false;
        }
    }

    private boolean searchHelper(String word, int index, TrieNode tmp) {
        if(tmp == null) return false;
        
        char c = word.charAt(index);
        if(c == '.') {
            if(index == word.length() - 1) {
                for(int i = 0; i < 26; i++) {
                    if(tmp.children[i] != null && tmp.children[i].isEnd) return true;
                }
                return false;
            } else {
                for(int i = 0; i < 26; i++) {
                if(tmp.children[i] == null) continue;
                    if(searchHelper(word, index + 1, tmp.children[i])) return true;
                }
                return false;
            }
        } else {
            if(index == word.length() - 1) {
                return tmp.children[c - 'a'] != null && tmp.children[c - 'a'].isEnd;
            } else {
                if(tmp.children[c - 'a'] == null) return false;
                return searchHelper(word, index + 1, tmp.children[c - 'a']);
            }
        }
    }

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode() {
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");