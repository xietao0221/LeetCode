// https://discuss.leetcode.com/topic/33246/java-15ms-easiest-solution-100-00
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, root, i, j, res);
            }
        }
        return res;
    }
    
    public void dfs(char[][] board, TrieNode root, int row, int col, List<String> res) {
        char c = board[row][col];
        if(c == '#' || root.children[c - 'a'] == null) return;

        String tmpWord = root.children[c - 'a'].word;
        if(tmpWord != null) {
            res.add(tmpWord);
            root.children[c - 'a'].word = null;     // delete word to avoid duplicates
        }

        board[row][col] = '#';      // use '#' to represent this cell is visited
        if(row > 0) dfs(board, root.children[c - 'a'], row - 1, col, res);
        if(col > 0) dfs(board, root.children[c - 'a'], row, col - 1, res);
        if(row < board.length-1) dfs(board, root.children[c - 'a'], row + 1, col, res);
        if(col < board[0].length-1) dfs(board, root.children[c - 'a'], row, col + 1, res);
        board[row][col] = c;        // backtracking before return
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words) {
            TrieNode tmp = root;
            for(char c: word.toCharArray()) {
                if(tmp.children[c - 'a'] == null) tmp.children[c - 'a'] = new TrieNode();
                tmp = tmp.children[c - 'a'];
            }
            tmp.word = word;            // beautiful, avoid the searching
        }
        return root;
    }

    class TrieNode {
        public String word = null;      // another representation of isEnd, more concise
        public TrieNode[] children = new TrieNode[26];
    }
}


// straight forward approach, but time consuming
/*
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];       // avoid cycle
        Trie root = new Trie();
        for(String s: words) root.insert(s);

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, root, visited, res, new StringBuilder(), i, j);
            }
        }
        return new ArrayList<>(res);
    }
    
    public void dfs(char[][] board, Trie root, boolean[][] visited, Set<String> res,
                    StringBuilder sb, int row, int col) {
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col]) return;
        
        // assume this letter is valid
        sb.append(board[row][col]);
        
        // if the current sb is a valid 'prefix', keep searching; otherwise delete one character and return
        if(!root.startsWith(sb.toString())) {
            sb.deleteCharAt(sb.length() - 1);     // backtracking before return
            return;
        }
        
        // if the current sb is a valid 'word', put it into result, and keep searching
        if(root.search(sb.toString())) res.add(sb.toString());

        visited[row][col] = true;
        dfs(board, root, visited, res, sb, row - 1, col);
        dfs(board, root, visited, res, sb, row + 1, col);
        dfs(board, root, visited, res, sb, row, col - 1);
        dfs(board, root, visited, res, sb, row, col + 1);
        
        // backtracking before return
        visited[row][col] = false;
        sb.deleteCharAt(sb.length() - 1);
        return;
    }
    
    class Trie {
        private TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }
    
        public void insert(String word) {
            TrieNode tmp = root;
            char[] wordArray = word.toCharArray();
            for(char c: wordArray) {
                if(tmp.children[c - 'a'] == null) tmp.children[c - 'a'] = new TrieNode();
                tmp = tmp.children[c - 'a'];
            }
            tmp.isEnd = true;
        }
    
        public boolean search(String word) {
            TrieNode tmp = root;
            char[] wordArray = word.toCharArray();
            for(char c: wordArray) {
                if(tmp.children[c - 'a'] == null) return false;
                tmp = tmp.children[c - 'a'];
            }
            return tmp.isEnd;
        }
    
        public boolean startsWith(String prefix) {
            TrieNode tmp = root;
            char[] wordArray = prefix.toCharArray();
            for(char c: wordArray) {
                if(tmp.children[c - 'a'] == null) return false;
                tmp = tmp.children[c - 'a'];
            }
            return true;
        }
    }
    
    class TrieNode {
        public boolean isEnd;
        public TrieNode[] children;
        public TrieNode() {
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }
}
*/