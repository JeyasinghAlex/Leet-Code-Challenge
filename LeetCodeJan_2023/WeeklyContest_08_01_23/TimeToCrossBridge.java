package WeeklyContest_08_01_23;

import java.util.PriorityQueue;

public class TimeToCrossBridge {

    public int findCrossingTime(int n, int k, int[][] time) {
        PriorityQueue<Integer> left = new PriorityQueue<>(
                (o, p) -> time[o][0] + time[o][2] == time[p][0] + time[p][2] ? p - o
                        : time[p][0] + time[p][2] - time[o][0] - time[o][2]),
                right = new PriorityQueue<>((o, p) -> time[o][0] + time[o][2] == time[p][0] + time[p][2] ? p - o
                        : time[p][0] + time[p][2] - time[o][0] - time[o][2]);
        PriorityQueue<int[]> left2 = new PriorityQueue<>((o, p) -> o[0] - p[0]),
                right2 = new PriorityQueue<>((o, p) -> o[0] - p[0]);
        for (int i = 0; i < time.length; i++) {
            left.offer(i);
        }
        int max = 0;
        for (int i = 0; n > 0 || !right.isEmpty()
                || !right2.isEmpty(); i = n > 0 && (!left.isEmpty() || !left2.isEmpty() && left2.peek()[0] <= i)
                || !right.isEmpty() || !right2.isEmpty() && right2.peek()[0] <= i ? i
                : Math.min(n == 0 || left2.isEmpty() ? Integer.MAX_VALUE : left2.peek()[0],
                right2.isEmpty() ? Integer.MAX_VALUE : right2.peek()[0])) {
            for (; !left2.isEmpty() && left2.peek()[0] <= i; left.offer(left2.poll()[1])) {
            }
            for (; !right2.isEmpty() && right2.peek()[0] <= i; right.add(right2.poll()[1])) {
            }
            if (right.isEmpty()) {
                n--;
                right2.add(new int[] { (i += time[left.peek()][0]) + time[left.peek()][1], left.poll() });
            } else if (n == 0) {
                max = Math.max(max, i += time[right.poll()][2]);
            } else {
                left2.add(new int[] { (i += time[right.peek()][2]) + time[right.peek()][3], right.poll() });
            }
        }
        return max;
    }
}
