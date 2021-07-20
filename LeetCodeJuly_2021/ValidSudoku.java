import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; ++i) {
            Set<Character> ro = new HashSet<>();
            Set<Character> co = new HashSet<>();
            for (int j = 0; j < col; ++j) {

                if (board[i][j] != '.' && !ro.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !co.add(board[j][i])) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (!isValid(board, i * 3, j * 3, i * 3 + 3, j * 3 + 3)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, int rowEnd, int colEnd) {

        Set<Character> set = new HashSet<>();
        for (int i = row; i < rowEnd; ++i) {
            for (int j = col; j < colEnd; ++j) {
                if (board[i][j] != '.' && !set.add(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
