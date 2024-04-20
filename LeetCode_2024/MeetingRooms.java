package LeetCode_2024;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {

    public List<Integer> maximumMeetings(int[] start, int[] end) {

        int n = start.length;
        List<Meeting> meetings = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; ++i)
            meetings.add(new Meeting(start[i], end[i], i + 1));

        Collections.sort(meetings, new MySort());
        int limit = meetings.get(0).end;
        ans.add(meetings.get(0).pos);

        for (int i = 1; i < n; ++i) {
            Meeting meeting = meetings.get(i);
            if (meeting.start > limit) {
                ans.add(meeting.pos);
                limit = meeting.end;
            }
        }
        return ans;
    }

    class MySort implements Comparator<Meeting> {

        @Override
        public int compare(Meeting m1, Meeting m2) {

            if (m1.end < m2.end)
                return -1;
            else if (m1.end > m2.end)
                return 1;
            else if (m1.pos < m2.pos)
                return -1;

            return 1;
        }
    }

    class Meeting {
        int start;
        int end;
        int pos;

        public Meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

}