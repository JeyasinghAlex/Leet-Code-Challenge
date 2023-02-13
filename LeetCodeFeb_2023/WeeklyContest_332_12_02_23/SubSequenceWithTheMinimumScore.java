package WeeklyContest_332_12_02_23;

public class SubSequenceWithTheMinimumScore {

    public int minimumScore(String s, String t) {

        int[] dp = new int[s.length() + 1];
        int min = t.length();
        for (int i = 0, j = 0; i < s.length(); i++) {
            dp[i + 1] = j += j < t.length() && s.charAt(i) == t.charAt(j) ? 1 : 0;
        }
        for (int i = s.length() - 1, j = t.length() - 1; i >= 0; i--) {
            min = Math.min(min, Math.max(0, (j -= j >= 0 && s.charAt(i) == t.charAt(j) ? 1 : 0) - dp[i] + 1));
        }
        return Math.min(min, t.length() - dp[s.length()]);
    }
}
