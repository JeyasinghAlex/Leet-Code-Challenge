package BiWeeklyContest_87_17_09_22;

public class SmallestSubArraysWithMaximumBitwiseOR {

    public int[] smallestSubarrays(int[] nums) {

        int n = nums.length;
        int[] last = new int[30];
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; --i) {
            int t = i;
            for (int j = 0; j < 30; ++j) {
                if (((nums[i] >> j) & 1) == 1) {
                    last[j] = i;
                } else if (last[j] != n) {
                    t = Math.max(t, last[j]);
                }
                res[i] = t - i + 1;
            }
        }
        return res;
    }
}
