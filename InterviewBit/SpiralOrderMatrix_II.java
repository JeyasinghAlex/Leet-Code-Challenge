package InterviewBit;

public class SpiralOrderMatrix_II {

    public int[][] generateMatrix(int A) {

        int[][] ans = new int[A][A];
        int row = 0;
        int col = 0;
        int endRow = A - 1;
        int endCol = A - 1;
        int cnt = 0;

        for (int j = 1; j <= A; ++j) {

            for (int i = col; i <= endCol; ++i) {
                ans[row][i] = ++cnt;
            }
            ++row;

            for (int i = row; i <= endRow; ++i) {
                ans[i][endCol] = ++cnt;
            }
            --endCol;

            for (int i = endCol; i >= col; --i) {
                ans[endRow][i] = ++cnt;
            }
            --endRow;

            for (int i = endRow; i >= row; --i) {
                ans[i][col] = ++cnt;
            }
            ++col;
        }
        return ans;
    }
}
