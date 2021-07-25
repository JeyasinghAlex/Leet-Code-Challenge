import java.util.*;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();

        int[] newInterval = intervals[0];
        list.add(newInterval);

        for (int[] interval : intervals) {

            if (interval[0] <= newInterval[1]){
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                list.add(interval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public int[][] merge_1(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> list = new LinkedList<>();

        for (int[] interval : intervals) {

            if (list.isEmpty() || list.getLast()[1] < interval[0]) {
                list.add(interval);
            } else {
                list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public int[][] merge_2(int[][] intervals) {

        Queue<int[]> qu = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> list = new ArrayList<>();

        for (int[] arr : intervals) {
            if (qu.isEmpty()) {
                qu.offer(arr);
            } else {
                int[] temp = qu.peek();
                if (temp[1] >= arr[0] && arr[1] >= temp[0]) {
                    int min = Math.min(temp[0], arr[0]);
                    int max = Math.max(temp[1], arr[1]);
                    qu.poll();
                    qu.offer(new int[]{min, max});
                } else {
                    list.add(qu.poll());
                    qu.offer(arr);
                }
            }
        }
        for (int[] ar : qu) {
            list.add(ar);
        }
        return list.toArray(new int[list.size()][]);
    }
}
