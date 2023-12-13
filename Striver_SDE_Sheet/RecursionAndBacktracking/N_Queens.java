package RecursionAndBacktracking;

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
        dfs(0, board, ans);
        return ans;
    }

    private void dfs(int col, char[][] board, List<List<String>> ans) {

        if (col == board[0].length) {
            List<String> list = construct(board);
            ans.add(list);
            return;
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
            list.add(new String(arr));
        }
        return list;
    }

    private boolean isValid(int row, int col, char[][] board) {
        return validateRow(row, col, board) &&
                validateCol(row, col, board) &&
                validateTriangle_1(row, col, board) &&
                validateTriangle_2(row, col, board);
    }

    private boolean validateTriangle_2(int row, int col, char[][] board) {

        int ro = row;
        int co = col;

        int r = board.length;
        int c = board[0].length;

        while (row >= 0 && col < c) {
            if (board[row][col] != '.') {
                return false;
            }
            --row;
            ++col;
        }

        row = ro;
        col = co;

        while (row < r && col >= 0) {
            if (board[row][col] != '.') {
                return false;
            }
            ++row;
            --col;
        }
        return true;
    }

    private boolean validateTriangle_1(int row, int col, char[][] board) {

        int ro = row;
        int co = col;

        int r = board.length;
        int c = board[0].length;

        while (row >= 0 && col >= 0) {
            if (board[row][col] != '.') {
                return false;
            }
            --row;
            --col;
        }

        row = ro;
        col = co;

        while (row < r && col < c) {
            if (board[row][col] != '.') {
                return false;
            }
            ++row;
            ++col;
        }
        return true;
    }

    private boolean validateCol(int row, int col, char[][] board) {
        int r = board.length;
        int c = board[0].length;

        for (int i = col; i < c; ++i) {
            if (board[row][i] != '.') {
                return false;
            }
        }

        for (int i = col; i >= 0; --i) {
            if (board[row][i] != '.') {
                return false;
            }
        }

        return true;
    }

    private boolean validateRow(int row, int col, char[][] board) {

        int r = board.length;
        int c = board[0].length;

        for (int i = row; i < r; ++i) {
            if (board[i][col] != '.') {
                return false;
            }
        }

        for (int i = row; i >= 0; --i) {
            if (board[i][col] != '.') {
                return false;
            }
        }
        return true;
    }
}
