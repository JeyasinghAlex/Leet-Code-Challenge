public class TeemoAttacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        for (int i = 1; i < timeSeries.length; ++i) {
            if (timeSeries[i] - timeSeries[i - 1] >= duration) {
                ans += duration;
            } else {
                ans += timeSeries[i] - timeSeries[i - 1];
            }
        }
        return ans + duration;
    }

    public int findPoisonedDuration_1(int[] timeSeries, int duration) {
        int ans = 0;
        for (int i = 1; i < timeSeries.length; ++i) {
            int temp =  timeSeries[i] - timeSeries[i - 1];
            ans += Math.min(temp, duration);
        }
        return ans + duration;
    }
}
