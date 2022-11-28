import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class TwoBestNonOverlappingEvents {

    public int maxTwoEvents(int[][] events) {

        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int maxValue = 0;
        int ans = 0;

        for (int[] event : events) {

            while (!pq.isEmpty()) {
                if (pq.peek()[0] >= event[0]) {
                    break;
                }
                int[] arr = pq.poll();
                maxValue = Math.max(maxValue, arr[1]);
            }
            ans = Math.max(ans, maxValue + event[2]);
            pq.offer(new int[]{event[1], event[2]});
        }
        return ans;
    }
}
