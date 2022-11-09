package WeeklyContest_297_12_06_22;

public class FairDistributionOfCookies {

    public int distributeCookies(int[] cookies, int k) {

        int[] childs = new int[k];
        return unfairness(0, cookies ,childs);
    }

    private int unfairness(int index, int[] cookies, int[] childs) {

        if (index == cookies.length) {
            int max = Integer.MIN_VALUE;
            for (int n : childs) {
                max = Math.max(max, n);
            }
            return max;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < childs.length; ++i) {
            childs[i] += cookies[index];
            int minUnfairness = unfairness(index + 1, cookies, childs);
            ans = Math.min(ans, minUnfairness);
            childs[i] -= cookies[index];
        }
        return ans;
    }
}
