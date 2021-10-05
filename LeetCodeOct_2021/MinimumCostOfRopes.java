import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostOfRopes {

    long minCost(long arr[], int n)
    {
        long min = 0;
        Queue<Long> qu = new PriorityQueue<>();
        for (long a : arr) {
            qu.offer(a);
        }

        while (qu.size() >= 2) {
            long a = qu.poll();
            long b = qu.poll();
            min += (a + b);
            qu.offer(a + b);
        }
        return min;
    }
}
