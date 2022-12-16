package BiWeeklyContest_76_16_04_22;

public class NumberOfWaysToBuyPensAndPencils {

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {

        long ans = 0l;

        for (int i = 0; i <= total; i += cost1) {
            int amount = total - i;
            ans += (amount / cost2) + 1;
        }
        return ans;
    }
}
