import java.util.HashMap;
import java.util.Map;

public class ThreeSumWithMultiplicity {

    public int threeSumMulti(int[] arr, int target) {

        long mod = (long) 1e9 + 7;
        Map<Integer, Long> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0L) + 1);
        }

        long count = 0;
        for (int x : map.keySet()) {
            for (int y : map.keySet()) {

                int z = target - x - y;

                if (map.containsKey(z)) {

                    long xFreq = map.get(x);
                    long yFreq = map.get(y);
                    long zFreq = map.get(z);

                    if (x < y && y < z) {
                        count += xFreq * yFreq * zFreq;
                    } else if (x == y && x != z) {
                        count += (xFreq * (xFreq - 1)) / 2 * zFreq;
                    } else if (x == y && y == z) {
                        count += (xFreq * (xFreq - 1) * (xFreq - 2)) / 6;
                    }
                }
            }
        }
        return (int) (count % mod);
    }
}
