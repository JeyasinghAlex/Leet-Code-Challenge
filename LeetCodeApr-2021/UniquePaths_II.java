import java.util.Arrays;

public class UniquePaths_II {

//    Dynamic programming
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        for (int i = 1; i < col - 1; ++i) {
            if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i + 1] = 1;
            }
        }

        for (int i = 1; i < row - 1; ++i) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i + 1][0] = 1;
            }
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (obstacleGrid[i][j] != 0) {
                    obstacleGrid[i][j] = 0;
                } else if (i == 0 || j == 0) {
                    obstacleGrid[i][j] = 1;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[row - 1][col - 1];
    }


//    Submission Result: Time Limit Exceeded
    private int dfs(int[][] arr, int row, int col) {

        if (row > arr.length - 1 || col > arr[0].length - 1 || arr[row][col] != 0) {
            return 0;
        }

        if (arr.length - 1 == row && arr[0].length - 1 == col){
            return 1;
        }
         return dfs(arr, row + 1, col) + dfs(arr, row, col + 1);
    }
}
