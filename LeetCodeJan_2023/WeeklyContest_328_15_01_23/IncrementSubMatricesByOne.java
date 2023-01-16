package WeeklyContest_328_15_01_23;

public class IncrementSubMatricesByOne {

    public int[][] rangeAddQueries(int n, int[][] queries) {

        int[][] mat = new int[n][n];

        for (int[] querie : queries) {
            int r1 = querie[0];
            int c1 = querie[1];
            int r2 = querie[2];
            int c2 = querie[3];

            for (int i = r1; i <= r2; ++i) {
                for (int j = c1; j <= c2; ++j) {
                    mat[i][j] += 1;
                }
            }
        }
        return mat;
    }
}
