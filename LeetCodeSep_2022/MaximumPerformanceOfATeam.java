import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumPerformanceOfATeam {

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        int[][] engineers = new int[n][2];

        for (int i = 0; i < n; ++i) {
            engineers[i][0] = speed[i];
            engineers[i][1] = efficiency[i];
        }

        Arrays.sort(engineers, (a, b) -> b[1] - a[1]);

        long sumOfSpeed = 0;
        long maxPerformance = 0;
        int mod = 1000000007;

        Queue<Integer> qu = new PriorityQueue<>();

        for (int i = 0; i < n; ++i) {

            sumOfSpeed += engineers[i][0];
            qu.offer(engineers[i][0]);

            if (qu.size() > k) {
                sumOfSpeed -= qu.poll();
            }

            maxPerformance = Math.max(maxPerformance, sumOfSpeed * engineers[i][1]);
        }

        return (int) (maxPerformance % mod);
    }
}
