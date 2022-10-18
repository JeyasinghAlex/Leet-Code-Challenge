package WeeklyContest_309_4_09_22;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms_III {

    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        Queue<Integer> unused = new PriorityQueue<>();
        Queue<int[]> engaged = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int[] count = new int[n];

        for (int i = 0; i < n; ++i) {
            unused.add(i);
        }

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            while (!engaged.isEmpty() && start >= engaged.peek()[1]) {
                int room = engaged.poll()[0];
                unused.offer(room);
            }

            if (unused.size() > 0) {
                int room = unused.poll();
                count[room]++;
                engaged.offer(new int[]{room, end});
            } else {
                int[] curr = engaged.poll();
                int room = curr[0];
                int currEnd = curr[1];
                int newEnd = currEnd + end - start;
                count[room]++;
                engaged.offer(new int[]{room, newEnd});
            }
        }

        int max = 0;
        int ans = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (count[i] >= max) {
                max = count[i];
                ans = i;
            }
        }
        return ans;
    }
}
