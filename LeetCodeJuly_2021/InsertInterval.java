import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            ++i;
        }

        while (i < intervals.length && intervals[i][1] >= newInterval[0] && intervals[i][0] <= newInterval[1]) {

            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            ++i;
        }
        list.add(newInterval);
        while (i < intervals.length) {
            list.add(intervals[i++]);
        }
        return list.toArray(new int[list.size()][]);
    }

    public int[][] insert_1(int[][] intervals, int[] newInterval) {

        int n = intervals.length + 1;
        int[][] temp = new int[n][2];
        int idx = 0;
        temp[idx++] = newInterval;
        for (int[] interval : intervals) {
            temp[idx++] = interval;
        }
        Arrays.sort(temp, (a, b) -> a[0] - b[0]);

        LinkedList<int[]> list = new LinkedList<>();

        for (int[] interval : temp) {

            if (list.isEmpty() || list.getLast()[1] < interval[0]) {
                list.add(interval);
            } else {
                list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public int[][] insert_2(int[][] intervals, int[] newInterval) {

        int n = intervals.length + 1;
        int[][] temp = new int[n][2];
        int idx = 0;
        temp[idx++] = newInterval;
        for (int[] interval : intervals) {
            temp[idx++] = interval;
        }
        Arrays.sort(temp, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();
        newInterval = temp[0];
        list.add(newInterval);

        for (int[] interval : temp) {

            if (newInterval[1] >= interval[0]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                newInterval = interval;
                list.add(newInterval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
