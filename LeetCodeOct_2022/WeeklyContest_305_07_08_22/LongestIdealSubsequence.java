package WeeklyContest_305_07_08_22;

public class LongestIdealSubsequence {

    public int longestIdealString(String s, int k) {

        int n = s.length();

        Integer[][] memo = new Integer[n + 1][1000];
        return memoization(s, memo, 0, 0, k);

    }

    private int memoization(String s, Integer[][] memo, int prev, int idx, int k) {

        if (idx == s.length())
            return 0;

        if (memo[idx][prev] != null)
            return memo[idx][prev];

        int diff = Math.abs(s.charAt(idx) - prev);
        int include = 0;
        int exclude = 0;

        if (prev == 0 || diff <= k) {
            include = 1 + memoization(s, memo, s.charAt(idx), idx + 1, k);
        }
        exclude = memoization(s, memo, prev, idx + 1, k);

        memo[idx][prev] = Math.max(include, exclude);
        return memo[idx][prev];
    }
}
