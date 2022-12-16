package BiWeeklyContest_76_16_04_22;

public class DesignAnATMMachine {

    private long[] money;
    private int[] coins = {20, 50, 100, 200, 500};
    public DesignAnATMMachine() {
        this.money = new long[5];
    }

    public void deposit(int[] banknotesCount) {

        for (int i = 0; i < banknotesCount.length; ++i) {
            money[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {

        int[] res = new int[5];
        for (int i = 4; i >= 0; --i) {

            int cnt = (int) Math.min(money[i], amount / coins[i]);
            res[i] = cnt;
            amount -= (cnt * coins[i]);
        }

        if (amount != 0) {
            return new int[]{-1};
        }

        for (int i = 0; i < 5; ++i) {
            money[i] -= res[i];
        }
        return res;
    }
}
