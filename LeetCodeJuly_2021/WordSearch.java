public class WordSearch {

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0, visited) ) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int r, int c, String word, int idx, boolean[][] visited) {

        if (idx == word.length()) {
            return true;
        }
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c] || board[r][c] != word.charAt(idx)) {
            return false;
        }

        visited[r][c] = true;
        if (dfs(board, r, c + 1, word, idx + 1, visited) ||
                dfs(board, r, c - 1, word, idx + 1, visited) ||
                dfs(board, r + 1, c, word, idx + 1, visited) ||
                dfs(board, r - 1, c, word, idx + 1, visited)) {
            return true;
        }
        visited[r][c] = false;
        return false;
    }

    private boolean result = false;
    public boolean exist_1(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {

                if (board[i][j] == word.charAt(0)) {
                    dfs_1(board, i, j, word, 0, visited);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void dfs_1(char[][] board, int r, int c, String word, int idx, boolean[][] visited) {

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c] ||  idx >= word.length() || board[r][c] != word.charAt(idx)) {
            return ;
        }

        if (idx == word.length() - 1) {
            result = true;
        }
        visited[r][c] = true;
        dfs_1(board, r, c + 1, word, idx + 1, visited);
        dfs_1(board, r, c - 1, word, idx + 1, visited);
        dfs_1(board, r + 1, c, word, idx + 1, visited);
        dfs_1(board, r - 1, c, word, idx + 1, visited);
        visited[r][c] = false;
    }
}
