package WeeklyContest_2_10_22;

public class MaximumSumOfAnHourglass {

    public int maxSum(int[][] a) {
        int n = a.length, m = a[0].length;
        int ans = 0;
        for(int i = 0;i < n-2;i++){
            for(int j = 0;j < m-2;j++){
                int s = a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j+1] + a[i+2][j] + a[i+2][j+1] + a[i+2][j+2];
                ans = Math.max(ans, s);
            }
        }
        return ans;
    }

    public int maxSum_1(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int max = 0;

        for (int i = 2; i < row; ++i) {
            for (int j = 2; j < col; ++j) {

                int a = calculateHourglass(i, j, grid);
                max = Math.max(max, a);
            }
        }
        return max;
    }

    private int calculateHourglass(int row, int col, int[][] grid) {

        int r = row - 2;
        int c = col - 2;

        int sum = 0;

        for (int i = r; i < r + 3; i = i + 2) {
            for (int j = c; j < c + 3; ++j) {
                sum += grid[i][j];
            }
        }

        sum += grid[r + 1][c + 1];
        return sum;
    }
}
