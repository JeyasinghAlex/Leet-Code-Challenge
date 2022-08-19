import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequences {

    public boolean isPossible(int[] nums) {

        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int n : nums) {

            if (freq.get(n) == 0) {
                continue;
            }

            if (need.containsKey(n) && need.get(n) > 0) {
                freq.put(n, freq.get(n) - 1);
                need.put(n, need.get(n) - 1);

                need.put(n + 1, need.getOrDefault(n + 1, 0) + 1);
            }
            else if (freq.containsKey(n) && freq.get(n) > 0 && freq.containsKey(n + 1) && freq.get(n + 1) > 0 && freq.containsKey(n + 2) && freq.get(n + 1) > 0) {

                freq.put(n, freq.get(n) - 1);
                freq.put(n + 1, freq.get(n + 1) - 1);
                freq.put(n + 2, freq.get(n + 2) - 1);

                need.put(n + 3, need.getOrDefault(n + 3, 0) + 1);
            }
            else {
                return false;
            }
        }
        return true;
    }
}
