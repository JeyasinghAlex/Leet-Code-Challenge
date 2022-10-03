public class MinimumTimeToMakeRopeColorful {

    public int minCost(String colors, int[] neededTime) {

        int n = colors.length();
        int minCost = 0;

        for (int i = 1; i < n; ++i) {
            if (colors.charAt(i - 1) == colors.charAt(i)) {
                minCost += Math.min(neededTime[i - 1], neededTime[i]);
                neededTime[i] = Math.max(neededTime[i - 1], neededTime[i]);
            }
        }
        return minCost;
    }
}
