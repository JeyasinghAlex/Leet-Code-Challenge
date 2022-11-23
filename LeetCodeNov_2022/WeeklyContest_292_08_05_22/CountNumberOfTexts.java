package WeeklyContest_292_08_05_22;

public class CountNumberOfTexts {

    private final int MOD = (int) 1e9 + 7;
    public int countTexts(String pressedKeys) {

        int n = pressedKeys.length();
        int[] keys = {0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
        Integer[] memo = new Integer[n];
        return memoization(0, pressedKeys, keys, memo);
    }

    private int memoization(int idx, String s, int[] keys, Integer[] memo) {

        if (idx == s.length()) {
            return 1;
        }
        if (memo[idx] != null) {
            return memo[idx];
        }

        int count = 0;
        int num = s.charAt(idx) - '0';
        int rep = keys[num];
        for (int i = 0; i < rep && idx + i < s.length() && s.charAt(idx) == s.charAt(idx + i); ++i) {
            count += memoization(idx + i + 1, s, keys, memo);
            count %= MOD;
        }
        memo[idx] = count;
        return count;
    }
}
