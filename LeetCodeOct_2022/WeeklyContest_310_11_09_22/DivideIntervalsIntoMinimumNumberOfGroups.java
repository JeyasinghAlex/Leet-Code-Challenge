package WeeklyContest_310_11_09_22;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class DivideIntervalsIntoMinimumNumberOfGroups {

    //This problem similar as maximum meeting room needed.
    public int minGroups(int[][] intervals) {

        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        Queue<Integer> qu = new PriorityQueue<>();

        for (int i = 0; i < n; ++i) {

            int[] interval = intervals[i];
            int start = interval[0];
            int end = interval[1];

            if (!qu.isEmpty() && start > qu.peek()) {
                qu.poll();
            }
            qu.offer(end);
        }
        return qu.size();
    }
}
