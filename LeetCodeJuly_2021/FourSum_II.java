import java.util.HashMap;
import java.util.Map;

public class FourSum_II {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int n : nums1) {
            for (int m : nums2) {
                int sum = n + m;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i : nums3) {
            for (int j  : nums4) {
                int sum = i + j;
                if (map.containsKey(-sum)) {
                    count += map.get(-sum);
                }
            }
        }
        return count;
    }
}