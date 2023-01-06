import java.util.Arrays;

public class MaximumIceCreamBars {

    public int maxIceCream(int[] costs, int coins) {

        int n = costs.length;
        int ans = 0;
        int i = 0;
        Arrays.sort(costs);

        while (i < n && costs[i] <= coins) {
            coins -= costs[i++];
            ++ans;
        }
        return ans;
    }
}
