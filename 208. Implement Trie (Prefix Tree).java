class TrieNode {
    boolean isEnd;
    TrieNode[] children;
    
    // Initialize your data structure here.
    public TrieNode() {
        this.isEnd = false;
        // do not 'new' each element, because 'null' represents there is no following characters
        this.children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode tmp = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(tmp.children[c - 'a'] == null) tmp.children[c - 'a'] = new TrieNode();
            tmp = tmp.children[c - 'a'];
        }
        tmp.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode tmp = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(tmp.children[c - 'a'] == null) return false;
            tmp = tmp.children[c - 'a'];
        }
        return tmp.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(tmp.children[c - 'a'] == null) return false;
            tmp = tmp.children[c - 'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");