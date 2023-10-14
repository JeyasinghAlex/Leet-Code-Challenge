package Arrays;

import java.util.ArrayList;
import java.util.*;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int[] newInterval = new int[2];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; ++i) {
            int[] interval = intervals[i];
            if (i == 0) {
                newInterval = interval;
                ans.add(newInterval);
            }
            else if (newInterval[1] >= interval[0]) {
                int max = Math.max(newInterval[1], interval[1]);
                newInterval[1] = max;
            }
            else {
                ans.add(interval);
                newInterval = interval;
            }
        }

        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); ++i) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
