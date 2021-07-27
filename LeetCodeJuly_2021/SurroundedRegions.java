public class SurroundedRegions {

    public void solve(char[][] board) {

        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if ((i == 0 || j == 0 || i == row - 1 || j == col - 1) && board[i][j] == 'O') {
                    dfs(board, i, j, 'Z');
                }
            }
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] != 'Z') {
                    board[i][j] = 'X';
                }else if (board[i][j] == 'Z') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c, char ch) {

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == 'X' || board[r][c] == ch) {
            return ;
        }

        board[r][c] =  ch;
        dfs(board, r, c + 1, ch);
        dfs(board, r, c - 1, ch);
        dfs(board, r + 1, c, ch);
        dfs(board, r - 1, c, ch);
    }
}
