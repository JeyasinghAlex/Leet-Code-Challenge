import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch_II {

    public static void main(String[] args) {
        char[][] board = {{'a'}};
        String[] words = {"a"};
        System.out.println(new WordSearch_II().findWords(board, words));
    }

    private TrieNode root = new TrieNode();
    public List<String> findWords(char[][] board, String[] words) {
        buildTrie(words);
        int row = board.length;
        int col = board[0].length;
        Set<String> ans = new HashSet<>();
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {

                dfs(board, i, j, visited, root, ans);

            }
        }
        return new ArrayList<>(ans);
    }


    private void dfs(char[][] board, int r, int c, boolean[][] visited, TrieNode node, Set<String> ans) {

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c] || node == null) {
            return;
        }

        if (node.get(board[r][c]).isEnd()) {
            ans.add(node.get(board[r][c]).getWord());
            return ;
        }

        visited[r][c] = true;
        dfs(board, r, c + 1, visited, node.get(board[r][c]), ans);
        dfs(board, r, c - 1, visited, node.get(board[r][c]), ans);
        dfs(board, r + 1, c, visited, node.get(board[r][c]), ans);
        dfs(board, r - 1, c, visited, node.get(board[r][c]), ans);
        visited[r][c] = false;

    }


    private void buildTrie(String[] words) {

        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {

                if (!node.containsKey(ch)) {
                    node.put(ch, new TrieNode());
                }
                node = node.get(ch);
            }
            node.setEnd();
            node.setWord(word);
        }
    }



    static class TrieNode {

        private TrieNode[] links;
        private boolean isEnd;
        private String word;

        public TrieNode() {
            this.links = new TrieNode[26];
        }

        public void setWord(String word) {
            this.word = word;
        }

        public String getWord() {
            return this.word;
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch, TrieNode node) {

            this.links[ch - 'a'] = node;
        }

        public TrieNode get(char ch) {
            return this.links[ch - 'a'];
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }
}
