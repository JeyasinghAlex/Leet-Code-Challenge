package WeeklyContest_291_01_05_22;

public class TotalAppealOfAString {

    public long appealSum(String s) {

        int n = s.length();
        long ans = 0l;
        int[] last = new int[26];
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            last[ch - 'a'] = i + 1;

            for (int cnt : last) {
                ans += cnt;
            }
        }
        return ans;
    }
}
