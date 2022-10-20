package WeeklyContest_308_28_8_22;

import java.util.Arrays;

public class LongestSubSequenceWithLimitedSum {

    public int[] answerQueries(int[] nums, int[] queries) {

        int n = nums.length;
        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            int s = sum;
            for (int j = n - 1 ; j >= 0; --j) {
                if (s <= queries[i]) {
                    ans[i] = j + 1;
                    break;
                }
                s -= nums[j];
            }
        }
        return ans;
    }
}
