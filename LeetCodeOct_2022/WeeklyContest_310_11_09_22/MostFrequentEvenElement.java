package WeeklyContest_310_11_09_22;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentEvenElement {

    public int mostFrequentEven(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = -1;
        int max = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                int val = map.get(num);
                if (val > max) {
                    ans = num;
                    max = val;
                }
                if (max == val) {
                    ans = Math.min(ans, num);
                }
            }
        }
        return ans;
    }
}
