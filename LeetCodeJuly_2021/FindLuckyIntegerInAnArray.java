import java.util.Map;
import java.util.TreeMap;

public class FindLuckyIntegerInAnArray {

    public int findLucky(int[] arr) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getKey() == entry.getValue()) {
                ans = entry.getKey();
            }
        }
        return ans;
    }
}
