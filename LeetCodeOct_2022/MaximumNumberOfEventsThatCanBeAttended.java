import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumNumberOfEventsThatCanBeAttended {

    public int maxEvents(int[][] events) {

        Queue<Integer> qu = new PriorityQueue<>();

        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int i = 0;
        int count = 0;
        int n = events.length;

        for (int d = 1; d <= 100000; ++d) {

            while (i < n && events[i][0] == d) {
                qu.offer(events[i++][1]);
            }

            while (!qu.isEmpty() && qu.peek() < d) {
                qu.poll();
            }

            if (!qu.isEmpty()) {
                qu.poll();
                ++count;
            }
        }
        return count;
    }
}
