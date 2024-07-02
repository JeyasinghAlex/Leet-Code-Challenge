package InterviewBit;

import java.util.*;

public class MeetingRooms {

    public int solve(int[][] meetings) {

        int n = meetings.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; ++i) {
            start[i] = meetings[i][0];
            end[i] = meetings[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int cnt = 0;
        int max = Integer.MIN_VALUE;
        int limit = end[0];
        int j = 0;
        for (int i = 0; i < n; ++i) {

            if (start[i] >= limit) {
                limit = end[++j];
            }
            else {
                ++cnt;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

    public int solve_1(int[][] meetings) {

        int n = meetings.length;
        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; ++i){
            int start = meetings[i][0];
            int end = meetings[i][1];

            if (!pq.isEmpty() && start >= pq.peek()) {
                pq.poll();
            }

            pq.offer(end);
        }

        return pq.size();
    }
}
