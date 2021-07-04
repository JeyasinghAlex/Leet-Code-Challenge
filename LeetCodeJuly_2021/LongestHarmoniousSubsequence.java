import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int max = 0;
        for (int n : map.keySet()) {

            if (map.containsKey(n + 1)) {
                max = Math.max(max, map.get(n) + map.get(n + 1));
            }
        }
        return max;
    }


    public int findLHS_1(int[] nums) {

        Map<Integer, Integer> map = new TreeMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int prev = 0;
        for (int n : map.keySet()) {
            prev = n;
            break;
        }
        int max = 0;
        for (int n : map.keySet()) {

            if (n - prev == 1) {
                max = Math.max(max, map.get(n) + map.get(prev));
            }
            prev = n;
        }
        return max;
    }
}
