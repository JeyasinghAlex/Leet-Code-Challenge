import java.util.HashMap;
import java.util.Map;

public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {

        int[] stops = new int[1001];
        for (int[] trip : trips) {
            stops[trip[1]] += trip[0];
            stops[trip[2]] -= trip[0];
        }

        for (int i = 0; i < 1001 && capacity >= 0; ++i) {
            capacity -= stops[i];
        }
        return capacity >= 0;
    }

    public boolean carPooling_1(int[][] trips, int capacity) {

        Map<Integer, Integer> from = new HashMap<>();
        Map<Integer, Integer> to = new HashMap<>();
        int stops = 0;

        for (int[] trip : trips) {
            from.put(trip[1], from.getOrDefault(trip[1], 0) + trip[0]);
            to.put(trip[2], to.getOrDefault(trip[2], 0) + trip[0]);
            stops = Math.max(stops, trip[2]);
        }

        int ans = 0;
        for (int i = 0; i <= stops; ++i) {
            if (to.containsKey(i)) {
                ans -= to.get(i);
            }
            if (from.containsKey(i)) {
                ans += from.get(i);
            }
            if (ans > capacity) {
                return false;
            }
        }
        return true;
    }
}