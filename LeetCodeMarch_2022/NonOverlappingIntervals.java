import java.util.Arrays;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {

        int n = intervals.length;
        if (n <= 1) {
            return 0;
        }
        int count = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int left = 0;
        int right = 1;
        while (right < n) {
            if (intervals[left][1] <= intervals[right][0]) {
                left = right;
                right++;
            } else if (intervals[left][1] <= intervals[right][1]) {
                count++;
                right++;
            } else if (intervals[left][1] > intervals[right][1]) {
                count++;
                left = right;
                right++;
            }
        }
        return count;
    }

    public int eraseOverlapIntervals_1(int[][] intervals) {

        int n = intervals.length;
        if (n <= 1) {
            return 0;
        }
        int count = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int prevEnd = intervals[0][1];
        for (int i = 1; i < n; ++i) {

            if (prevEnd > intervals[i][0]) {
                ++count;
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            } else {
                prevEnd = intervals[i][1];
            }
        }
        return count;
    }
}
