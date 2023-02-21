package WeeklyContest_333_19_02_23;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MergeTwo_2D_ArraysBySummingValues {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            int[] temp = nums1[i];

            int key = temp[0];
            int value = temp[1];

            map.put(key, map.getOrDefault(key, 0) + value);
        }

        for (int i = 0; i < m; ++i) {

            int[] temp = nums2[i];

            int key = temp[0];
            int value = temp[1];

            map.put(key, map.getOrDefault(key, 0) + value);
        }

        int[][] ans = new int[map.size()][2];

        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans[idx][0] = entry.getKey();
            ans[idx][1] = entry.getValue();
            ++idx;
        }

        Arrays.sort(ans, (a, b) -> a[0] - b[0]);
        return ans;
    }
}
