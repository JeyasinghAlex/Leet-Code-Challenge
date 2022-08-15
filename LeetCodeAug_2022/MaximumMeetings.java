import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumMeetings {

    static class Meeting {
        int start;
        int end;
        int pos;

        Meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    static class MySort implements Comparator<Meeting> {

        public int compare(Meeting a, Meeting b) {

            if (a.end < b.end) {
                return -1;
            } else if (a.end > b.end) {
                return 1;
            } else if (a.pos < b.pos) {
                return -1;
            }
            return 1;
        }
    }
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int[] start, int[] end, int n)
    {
        // add your code here

        List<Meeting> meetings = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            meetings.add(new Meeting(start[i], end[i], i + 1));
        }

        Collections.sort(meetings, new MySort());

        int limit = meetings.get(0).end;
        ans.add(meetings.get(0).pos);

        int count = 1;
        for (int i = 1; i < n; ++i) {

            Meeting m = meetings.get(i);
            if (m.start > limit) {
                ++count;
                ans.add(m.pos);
                limit = m.end;
            }
        }
        return count;
    }
}
