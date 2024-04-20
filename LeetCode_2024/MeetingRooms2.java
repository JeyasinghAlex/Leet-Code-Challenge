package LeetCode_2024;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms2 {

    public int solve(int[][] meetings) {

        int n = meetings.length;
        int ans = 0;

        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        Queue<Integer> qu = new PriorityQueue<>();

        for (int i = 0; i < n; ++i) {

            int[] meeting = meetings[i];
            int start = meeting[0];
            int end = meeting[1];

            if (!qu.isEmpty() && start >= qu.peek()) {
                qu.poll();
            }
            qu.offer(end);
        }
        return qu.size();
    }
}
