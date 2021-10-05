import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {

    public int longestArithSeqLength(int[] nums) {

        int n = nums.length;
        Map<Integer, Integer>[] maps = new HashMap[n];
        for (int i = 0; i < n; ++i) {
            maps[i] = new HashMap<>();
        }

        int max = 2;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int diff = nums[i] - nums[j];
                int curr = maps[j].getOrDefault(diff, 1);
                maps[i].put(diff, curr + 1);
                max = Math.max(max, maps[i].get(diff));
            }
        }
        return max;
    }
}
