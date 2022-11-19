package BiWeeklyContest_78_14_05_22;

public class NumberOfWaysToSplitArray {

    public int waysToSplitArray(int[] nums) {

        int n = nums.length;
        long[] prefSum = new long[n];
        prefSum[0] = nums[0];
        long totalSum = nums[0];

        for (int i = 1; i < n; ++i) {
            prefSum[i] += prefSum[i - 1] + nums[i];
            totalSum += nums[i];
        }

        int ans = 0;

        for (int i = 0; i < n - 1; ++i) {
            if (prefSum[i] >= totalSum - prefSum[i]) {
                ++ans;
            }
        }
        return ans;
    }
}
