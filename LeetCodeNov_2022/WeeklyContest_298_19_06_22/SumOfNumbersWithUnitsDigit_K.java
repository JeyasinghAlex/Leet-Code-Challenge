package WeeklyContest_298_19_06_22;

import java.util.ArrayList;
import java.util.List;

public class SumOfNumbersWithUnitsDigit_K {

    public int minimumNumbers(int num, int k) {

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= num; ++i) {
            if (i % 10 == k) {
                list.add(i);
            }
        }

        Integer[][] memo = new Integer[list.size() + 1][num + 1];
        int ans = memoization(0, list, num, memo);
        return ans == Integer.MAX_VALUE - 1 ? -1 : ans;
    }

    public int minimumNumbers_dp(int num, int k) {

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= num; ++i) {
            if (i % 10 == k) {
                list.add(i);
            }
        }

        int n = list.size();
        int[][] dp = new int[n + 1][num + 1];

        for (int i = 1; i <= num; ++i) {
            dp[0][i] = (int) 1e5;
        }


        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= num; ++j) {
                if (j < list.get(i - 1)) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - list.get(i - 1)]);
                }
            }
        }
        return dp[n][num] > (int) 1e4 ? -1 : dp[n][num];
    }

    private int memoization(int index, List<Integer> list, int target, Integer[][] memo) {

        if (target == 0) {
            return 0;
        }

        if (target < 0 || index == list.size()) {
            return Integer.MAX_VALUE - 1;
        }

        if (memo[index][target] != null) {
            return memo[index][target];
        }

        int exclude = memoization(index + 1, list, target, memo);
        int include = 1 + memoization(index, list, target - list.get(index), memo);
        int ans = Math.min(exclude, include);
        memo[index][target] = ans;
        return ans;
    }
}
