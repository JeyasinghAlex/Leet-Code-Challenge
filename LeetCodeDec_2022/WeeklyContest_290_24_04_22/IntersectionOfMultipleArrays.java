package WeeklyContest_290_24_04_22;

import java.util.*;

public class IntersectionOfMultipleArrays {

    public List<Integer> intersection(int[][] nums) {

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] num : nums) {
            for (int nu : num) {
                map.put(nu, map.getOrDefault(nu, 0) + 1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (val >= n) {
                ans.add(key);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
