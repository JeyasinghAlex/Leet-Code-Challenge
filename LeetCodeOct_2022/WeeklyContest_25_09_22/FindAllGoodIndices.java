package WeeklyContest_25_09_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllGoodIndices {

    public List<Integer> goodIndices(int[] nums, int k) {

        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];
        List<Integer> ans = new ArrayList<>();

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < n; ++i) {
            if (nums[i - 1] >= nums[i]) {
                left[i] += left[i - 1];
            }
        }

        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] <= nums[i + 1]) {
                right[i] += right[i + 1];
            }
        }

        for (int i = k; i < n - k; ++i) {
            if (left[i - 1] >= k && right[i + 1] >= k) {
                ans.add(i);
            }
        }
        return ans;
    }
}
