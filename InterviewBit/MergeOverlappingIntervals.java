package InterviewBit;

import java.util.ArrayList;

public class MergeOverlappingIntervals {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        int n = intervals.size();
        intervals.sort((a, b) -> a.start - b.start);
        ArrayList<Interval> ans = new ArrayList<>();

        Interval newInterval = intervals.get(0);
        ans.add(newInterval);

        for (int i = 1; i < n; ++i) {

            Interval interval = intervals.get(i);
            if (newInterval.end >= interval.start) {
                int end = Math.max(newInterval.end, interval.end);
                newInterval.end = end;
            }
            else {
                newInterval = interval;
                ans.add(newInterval);
            }
        }
        return ans;
    }
}
