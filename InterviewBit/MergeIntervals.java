package InterviewBit;

import java.util.ArrayList;




public class MergeIntervals {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> ans = new ArrayList<>();
        int n = intervals.size();
        int i = 0;
        while (i < n && intervals.get(i).end < newInterval.start) {
            ans.add(intervals.get(i));
            ++i;
        }

        while (i < n && intervals.get(i).end >= newInterval.start && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            ++i;
        }
        ans.add(newInterval);
        while (i < n) {
            ans.add(intervals.get(i));
            ++i;
        }
        return ans;
    }

        public  ArrayList<Interval> insert_1(ArrayList<Interval> intervals, Interval newInterval) {


        ArrayList<Interval> ans = new ArrayList<>();
        intervals.add(newInterval);
        int n = intervals.size();
        intervals.sort((a, b) -> a.start - b.start);

        ans.add(intervals.get(0));
        newInterval = ans.get(0);

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
