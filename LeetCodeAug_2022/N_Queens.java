import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens {

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        List<List<String>> ans = new ArrayList<>();

        for (char[] arr : board) {
            Arrays.fill(arr, '.');
        }

        int[] leftRow = new int[n];
        int[] upperTriangle = new int[2 * n - 1];
        int[] lowerTriangle = new int[2 * n - 1];
        dfs(0, board, leftRow, upperTriangle, lowerTriangle, ans, n);

        return ans;
    }

    private void dfs(int col, char[][] board, int[] leftRow, int[] upperTriangle, int[] lowerTriangle, List<List<String>> ans, int n) {

        if (col == board[0].length) {

            List<String> list = construct(board);
            ans.add(list);
            return ;
        }

        for (int row = 0; row < board.length; ++row) {

            if (leftRow[row] == 0 && lowerTriangle[row + col] == 0 && upperTriangle[n - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerTriangle[row + col] = 1;
                upperTriangle[n - 1 + col - row] = 1;
                dfs(col + 1, board, leftRow, upperTriangle, lowerTriangle, ans, n);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerTriangle[row + col] = 0;
                upperTriangle[n - 1 + col - row] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens_1(int n) {

        char[][] board = new char[n][n];

        List<List<String>> ans = new ArrayList<>();

        for (char[] arr : board) {
            Arrays.fill(arr, '.');
        }

        dfs(0, board, ans);

        return ans;
    }

    private void dfs(int col, char[][] board, List<List<String>> ans) {

        if (col == board[0].length) {

            List<String> list = construct(board);
            ans.add(list);
            return ;
        }

        for (int row = 0; row < board.length; ++row) {

            if (isValid(row, col, board)) {
                board[row][col] = 'Q';
                dfs(col + 1, board, ans);
                board[row][col] = '.';
            }
        }
    }

    private List<String> construct(char[][] board) {

        List<String> list = new ArrayList<>();

        for (char[] arr : board) {
            String s = new String(arr);
            list.add(s);
        }
        return list;
    }

    private boolean isValid(int r, int c, char[][] board) {

        /**
         * Reference link:
         * https://www.youtube.com/watch?v=i05Ju7AftcM&t=1811s&ab_channel=takeUforward
         */

        /**
         * Only upper triangle and lower triangle and row is enough.
         * No need to check all direction;
         */
        return validateRow(r, c, board)
                && validateColumn(r, c, board)
                && validateDiagonal_1(r, c, board)
                && validateDiagonal_2(r, c, board);
    }

    private boolean validateRow(int ro, int co, char[][] board) {

        int row = board.length;
        int col = board[0].length;

        for (int i = ro; i < row; ++i) {

            if (board[i][co] != '.') {
                return false;
            }
        }

        for (int i = ro; i >= 0; --i) {

            if (board[i][co] != '.') {
                return false;
            }
        }

        return true;

    }

    private boolean validateColumn(int ro, int co, char[][] board) {

        int row = board.length;
        int col = board[0].length;

        for (int i = co; i < col; ++i) {

            if (board[ro][i] != '.') {
                return false;
            }
        }

        for (int i = co; i >= 0; --i) {

            if (board[ro][i] != '.') {
                return false;
            }
        }
        return true;
    }

    private boolean validateDiagonal_1(int ro, int co, char[][] board) {

        int row = board.length;
        int col = board[0].length;

        int r = ro;
        int c = co;

        while (r >= 0 && c >= 0) {

            if (board[r][c] != '.') {
                return false;
            }
            --r;
            --c;
        }

        r = ro;
        c = co;

        while (r < row && c < col) {
            if (board[r][c] != '.') {
                return false;
            }
            ++r;
            ++c;
        }
        return true;
    }

    private boolean validateDiagonal_2(int ro, int co, char[][] board) {

        int row = board.length;
        int col = board[0].length;

        int r = ro;
        int c = co;

        while (r >= 0 && c < col) {

            if (board[r][c] != '.') {
                return false;
            }
            --r;
            ++c;
        }

        r = ro;
        c = co;

        while (r < row && c >= 0) {

            if (board[r][c] != '.') {
                return false;
            }
            ++r;
            --c;
        }
        return true;
    }
}
