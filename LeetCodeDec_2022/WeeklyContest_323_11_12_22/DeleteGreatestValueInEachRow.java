package WeeklyContest_323_11_12_22;

import java.util.Arrays;

public class DeleteGreatestValueInEachRow {

    public int deleteGreatestValue(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        for(int[] arr : grid) {
            Arrays.sort(arr);
        }

        int ans = 0;
        for (int i = 0; i < col; ++i) {
            int max = Integer.MIN_VALUE;
            for (int j = 0;j < row; ++j) {
                max = Math.max(max, grid[j][i]);
            }
            ans += max;
        }
        return ans;
    }
}
