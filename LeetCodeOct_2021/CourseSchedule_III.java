import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class CourseSchedule_III {

    public int scheduleCourse(int[][] courses) {

        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        Queue<Integer> qu = new PriorityQueue<>((a, b) -> b - a);

        int time = 0;
        for (int[] temp : courses) {
            if (time + temp[0] <= temp[1]) {
                time += temp[0];
                qu.offer(temp[0]);
            } else if (!qu.isEmpty() && qu.peek() > temp[0]) {
                time += temp[0] - qu.poll();
                qu.offer(temp[0]);
            }
        }
        return qu.size();
    }
}