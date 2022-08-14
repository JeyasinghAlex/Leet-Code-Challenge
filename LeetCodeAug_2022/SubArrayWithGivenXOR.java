import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenXOR {

    public int solve(int[] nums, int k) {

        int n = nums.length;
        int xor = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {

            xor = xor ^ nums[i];

            if (map.containsKey(xor ^ k)) {
                count += map.get(xor ^ k);
            }

            if (xor == k) {
                count++;
            }

            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}
