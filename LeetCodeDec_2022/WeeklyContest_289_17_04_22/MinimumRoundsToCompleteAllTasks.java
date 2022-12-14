package WeeklyContest_289_17_04_22;

import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsToCompleteAllTasks {

    public int minimumRounds(int[] tasks) {

        int n = tasks.length;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        for (int val : map.values()) {
            if (val == 1) {
                return -1;
            }
        }

        for (int key : map.keySet()) {
            int val = map.get(key);
            if (val % 3 == 0) {
                ans += val / 3;
            } else {
                ans += (val / 3) + 1;
            }
        }
        return ans;
    }
}
