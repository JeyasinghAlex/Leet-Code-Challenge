public class CountNegativeNumbersInSortedMatrix {

    public int countNegatives(int[][] grid) {

        int row = grid.length, col = grid[0].length;
        int r = 0, c = col - 1;
        int cnt = 0;

        while (r < row && c >= 0) {

            if (grid[r][c] < 0) {
                cnt += row - r;
                --c;
            } else {
                ++r;
            }
        }
        return cnt;
    }

    public int countNegatives_1(int[][] grid) {

        int count = 0;
        for (int[] arr : grid) {
            for (int n : arr) {

                count += n < 0 ? 1 : 0;
            }
        }
        return count;
    }
}
