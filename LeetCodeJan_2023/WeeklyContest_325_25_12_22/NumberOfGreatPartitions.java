package WeeklyContest_325_25_12_22;

public class NumberOfGreatPartitions {

    private static final int MOD = (int) 1e9 + 7;
    public int countPartitions(int[] nums, int k) {

        int n = nums.length;
        long sum = 0;
        int totalPair = 1;
        Integer[][] memo = new Integer[n + 1][k + 1];

        for (int num : nums) {
            sum += num;
            totalPair = (totalPair * 2) % MOD;
        }

        if (sum < k * 2L) {
            return 0;
        }

        int count = memoization(0, 0, nums, memo, k) % MOD;
        count = (count * 2) % MOD;
        int res = (totalPair - count + MOD) % MOD;
        return res;

    }

    private int memoization(int idx, int sum, int[] nums, Integer[][] memo, int target) {

        if (sum > target) {
            return 0;
        }

        if (idx == memo.length - 1) {
            if (sum < target) {
                return 1;
            }
            return 0;
        }

        if (memo[idx][sum] != null) {
            return memo[idx][sum];
        }

        int include = memoization(idx + 1, sum + nums[idx], nums, memo, target) % MOD;
        int exclude = memoization(idx + 1, sum, nums, memo, target) % MOD;

        memo[idx][sum] = (include + exclude) % MOD;
        return memo[idx][sum];
    }
}
