import java.util.HashMap;
import java.util.Map;

public class SumOfUniqueElements {

    public int usingArray(int[] nums) {

        int[] freq = new int[101];
        for (int num : nums) {
            freq[num]++;
        }

        int ans = 0;
        for (int i = 0; i < 101; ++i) {
            ans += freq[i] == 1 ? i : 0;
        }
        return ans;
    }

    public int usingMap(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                ans += entry.getKey();
            }
        }
        return ans;
    }
}
