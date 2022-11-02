package BiWeeklyContest_82_07_09_22;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TheLatestTimeToCatchBus {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {

        int n = buses.length;
        Set<Integer> set = new HashSet<>();
        Arrays.sort(buses);
        Arrays.sort(passengers);

        for (int p : passengers) {
            set.add(p);
        }

        int j = 0;
        int time = 0;
        int cnt = 0;
        for (int i = 0; i < n; ++i) {

            cnt = 0;
            while (j < passengers.length) {
                if (passengers[j] <= buses[i] && cnt < capacity) {
                    time = passengers[j];
                    ++cnt;
                    ++j;
                } else {
                    break;
                }
            }
        }
        if (cnt < capacity && time < buses[n - 1]) {
            return buses[n - 1];
        }

        while (set.contains(time)) {
            --time;
        }
        return time;
    }

}
