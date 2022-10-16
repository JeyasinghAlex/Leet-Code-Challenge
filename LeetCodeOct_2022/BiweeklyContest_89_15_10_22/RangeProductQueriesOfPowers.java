package BiweeklyContest_89_15_10_22;

public class RangeProductQueriesOfPowers {

    public int[] productQueries(int n, int[][] queries) {

        int MOD = 1000000007;
        int len = queries.length;
        int[] ans = new int[len];

        int cnt = bitCount(n);
        int[] arr = new int[cnt];
        fillArr(arr, n);

        for (int i = 0; i < len; ++i) {

            long prod = 1;
            int[] querie = queries[i];

            int st = querie[0];
            int ed = querie[1];

            for (int j = st; j <= ed; ++j) {
                prod = (prod * arr[j]) % MOD;
            }
            ans[i] = (int) prod;
        }
        return ans;
    }

    private void fillArr(int[] arr, int n) {

        int idx = 0;
        for (int i = 0; i < 30; ++i) {
            if ((n & (1 << i)) != 0) {
                arr[idx++] = 1 << i;
            }
        }
    }

    private int bitCount(int n) {

        int cnt = 0;
        while (n > 0) {
            cnt += n & 1;
            n = n >>> 1;
        }
        return cnt;
    }
}
