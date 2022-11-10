package WeeklyContest_296_05_06_22;

import java.util.HashMap;
import java.util.Map;

public class ReplaceElementsInAnArray {

    public int[] arrayChange(int[] nums, int[][] operations) {

        int n = nums.length;
        int[] ans = new int[n];

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; ++i) {
            map.put(nums[i], i);
        }

        for (int[] operation : operations) {
            int old = operation[0];
            int nw = operation[1];

            int idx = map.get(old);
            map.remove(old);
            map.put(nw, idx);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            ans[value] = key;
        }
        return ans;
    }
}
