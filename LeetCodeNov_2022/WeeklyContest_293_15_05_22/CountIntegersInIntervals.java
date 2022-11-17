package WeeklyContest_293_15_05_22;

import java.util.TreeMap;

public class CountIntegersInIntervals {

    private TreeMap<Integer, Integer> tMap;
    private int cnt;
    public CountIntegersInIntervals() {
        this.tMap = new TreeMap<>();
    }

    public void add(int left, int right) {

        if (tMap.floorKey(right) == null || tMap.get(tMap.floorKey(right)) < left) {
            tMap.put(left, right);
            cnt += right - left + 1;
            return ;
        }

        while (true) {

            int l = tMap.floorKey(right);
            int r = tMap.get(l);

            left = Math.min(left, l);
            right = Math.max(right, r);

            cnt -= (r - l + 1);
            tMap.remove(l);

            if (tMap.floorKey(right) == null || tMap.get(tMap.floorKey(right)) < left) {
                tMap.put(left, right);
                cnt += right - left + 1;
                break;
            }
        }
    }

    public int count() {
        return cnt;
    }
}
