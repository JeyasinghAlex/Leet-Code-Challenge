public class MaximumScoreFromPerformingMultiplicationOperations {

    private Integer[][] memo;
    private int n;
    private int m;

    public int maximumScore(int[] nums, int[] multipliers) {

        n = nums.length;
        m = multipliers.length;

        memo = new Integer[m][m];
        return memoization(0, 0, nums, multipliers);
    }

    private int memoization(int i, int l, int[] nums, int[] multi) {

        if (i == m) {
            return 0;
        }

        if (memo[l][i] != null) {
            return memo[l][i];
        }

        int pickLeft = memoization(i + 1, l + 1, nums, multi) + nums[l] * multi[i];
        int pickRight = memoization(i + 1, l, nums, multi) + nums[n - (i - l) - 1] * multi[i];
        memo[l][i] = Math.max(pickLeft, pickRight);
        return memo[l][i];
    }
}
