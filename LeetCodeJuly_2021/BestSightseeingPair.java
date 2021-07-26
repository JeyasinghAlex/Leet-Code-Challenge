public class BestSightseeingPair {

    public int maxScoreSightseeingPair(int[] values) {

        // values[i] + values[j] + i - j => (values[i] + i) + (values[j] - j)

        int prevMax = values[0] + 0;//values[i] + i
        int ans = 0;
        for (int j = 1; j < values.length; ++j) {
            ans = Math.max(ans, prevMax + values[j] - j);
            prevMax = Math.max(prevMax, values[j] + j);
        }
        return ans;
    }
}
