package WeeklyContest_324_18_12_22;

public class CycleLengthQueriesInTree {

    public int[] cycleLengthQueries(int n, int[][] queries) {
        int len = queries.length;
        int[] ans = new int[len];

        for (int i = 0; i < len; ++i) {

            int cnt = 1;
            int[] querie = queries[i];
            int a = querie[0];
            int b = querie[1];

            while (a != b) {
                if (a > b) {
                    a /= 2;
                } else {
                    b /= 2;
                }
                ++cnt;
            }
            ans[i] = cnt;
        }
        return ans;

    }
}
