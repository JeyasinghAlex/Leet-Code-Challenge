package BiWeeklyContest_87_17_09_22;

public class MinimumMoneyRequiredBeforeTransactions {

    public long minimumMoney(int[][] transactions) {
        long res = 0; int v = 0;
        for (int[] a : transactions) {
            v = Math.max(v, Math.min(a[0], a[1]));
            res += Math.max(a[0] - a[1], 0);
        }
        return res + v;
    }
}
