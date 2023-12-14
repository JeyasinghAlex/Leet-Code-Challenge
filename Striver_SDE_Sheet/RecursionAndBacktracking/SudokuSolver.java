package RecursionAndBacktracking;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {

        int r = board.length;
        int c = board[0].length;

        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ++ch) {
                        if (isValid(i, j, ch, board)) {
                            board[i][j] = ch;
                            if (backtrack(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int r, int c, char ch, char[][] board) {

        int n = board.length;

        for (int i = 0; i < n; ++i) {
            if (board[i][c] == ch) {
                return false;
            }
            if (board[r][i] == ch) {
                return false;
            }
        }

        int subRow = r - (r % 3);
        int subCol = c - (c % 3);

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[subRow + i][subCol + j] == ch) {
                    return false;
                }
            }
        }
        return true;
    }
}
