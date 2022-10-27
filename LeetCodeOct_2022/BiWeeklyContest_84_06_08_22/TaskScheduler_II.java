package BiWeeklyContest_84_06_08_22;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler_II {

    public long taskSchedulerII(int[] tasks, int space) {

        int n = tasks.length;
        long day = 0L;
        Map<Integer, Long> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            ++day;
            if (map.containsKey(tasks[i])) {
                long val = map.get(tasks[i]);
                long diff = day - val;
                if (diff <= space) {
                    day += (space - diff) + 1;
                }
            }
            map.put(tasks[i], day);
        }
        return day;
    }
}
