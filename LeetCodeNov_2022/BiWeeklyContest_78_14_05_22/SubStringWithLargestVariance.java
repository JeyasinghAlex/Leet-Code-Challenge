package BiWeeklyContest_78_14_05_22;

public class SubStringWithLargestVariance {

    public int largestVariance(String s) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int ans = 0;
        for (char a = 'a'; a <= 'z'; ++a) {
            for (char b = 'a'; b <= 'z'; ++b) {
                if (freq[a - 'a'] != 0 && freq[b - 'a'] != 0) {
                    ans = Math.max(ans, getMax(a, b, freq[a - 'a'], s));
                }
            }
        }
        return ans;

    }

    private int getMax(char a, char b, int left, String s) {

        if (a == b) {
            return 0;
        }

        int max = 0;
        int cntA = 0;
        int cntB = 0;
        for (char ch : s.toCharArray()) {

            if (ch != a && ch != b) {
                continue;
            }

            if (ch == b) {
                ++cntB;
            } else {
                ++cntA;
                --left;
            }

            if (cntA > 0 && cntB > 0) {
                max = Math.max(max, cntB - cntA);
            }
            if (cntA > cntB && left > 0) {
                cntA = 0;
                cntB = 0;
            }
        }
        return max;
    }
}
