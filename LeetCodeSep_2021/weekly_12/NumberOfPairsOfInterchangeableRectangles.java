package weekly_12;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPairsOfInterchangeableRectangles {

    public long interchangeableRectangles(int[][] rectangles) {

        Map<String, Integer> map = new HashMap<>();
        long ans = 0;
        for (int[] arr : rectangles) {
            int a = arr[0];
            int b = arr[1];
            int gcd = gcd(a, b);
            a /= gcd;
            b /= gcd;
            String key = a + "/" + b;
            map.put(key, map.getOrDefault(key, 0) + 1);

            ans += map.get(key)-1;
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
