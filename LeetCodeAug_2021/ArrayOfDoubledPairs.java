import java.util.*;

public class ArrayOfDoubledPairs {

    public boolean canReorderDoubled(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Arrays.sort(arr);
        for (int n : arr) {

            int a = n * 2;
            if (map.containsKey(n) && map.containsKey(a)) {
                int min = Math.min(map.get(a), map.get(n));
                int x = map.get(a) - min;
                int y = map.get(n) - min;
                if (x == 0) {
                    map.remove(a);
                } else {
                    map.put(a, x);
                }
                if (y == 0) {
                    map.remove(n);
                } else {
                    map.put(n, y);
                }
            }
        }
        return map.isEmpty();
    }
}
