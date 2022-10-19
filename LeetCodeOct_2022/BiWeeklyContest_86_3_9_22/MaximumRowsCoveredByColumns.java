package BiWeeklyContest_86_3_9_22;

public class MaximumRowsCoveredByColumns {

    public int maximumRows(int[][] matrix, int numSelect) {

        int n = matrix[0].length;
        boolean[] selectedCol = new boolean[n];
        dfs(matrix, selectedCol, numSelect, 0);
        return max;
    }

    private int max = 0;
    private void dfs(int[][] matrix, boolean[] selectedCol, int n, int c) {

        if (n == 0) {
            int rowCnt = countRow(matrix, selectedCol);
            max = Math.max(max, rowCnt);
            return ;
        }

        if (c == matrix[0].length) {
            return ;
        }

        selectedCol[c] = true;
        dfs(matrix, selectedCol, n - 1, c + 1);
        selectedCol[c] = false;
        dfs(matrix, selectedCol, n, c + 1);
    }

    private int countRow(int[][] matrix, boolean[] selectedCol) {

        int row = matrix.length;
        int col = matrix[0].length;

        int cnt = 0;
        for (int i = 0; i < row; ++i) {
            boolean flag = true;
            for (int j = 0; j < col; ++j) {
                if (!selectedCol[j] && matrix[i][j] == 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ++cnt;
            }
        }
        return cnt;
    }
}
