package WeeklyContest_291_01_05_22;

import java.util.HashSet;
import java.util.Set;

public class K_DivisibleElementsSubArrays {

    public int countDistinct(int[] nums, int k, int p) {

        int n = nums.length;

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < n; ++j) {
                if (nums[j] % p == 0) {
                    ++cnt;
                }
                if (cnt > k) {
                    break;
                }
                sb.append(nums[j]).append("_");
                set.add(sb.toString());
            }
        }
        return set.size();
    }
}
