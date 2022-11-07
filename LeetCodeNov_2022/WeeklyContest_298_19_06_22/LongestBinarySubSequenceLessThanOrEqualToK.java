package WeeklyContest_298_19_06_22;

public class LongestBinarySubSequenceLessThanOrEqualToK {

    public int longestSubsequence(String s, int k) {

        int n = s.length();
        int sum = 0;

        int zero = 0;
        int one = 0;
        int bit = 0;

        for (int i = n - 1; i >= 0; --i) {

            if (s.charAt(i) == '0') {
                ++zero;
            } else if (bit < 30){
                sum += 1 << bit;
                if (sum <= k)
                    ++one;
            }
            ++bit;
        }
        return zero + one;
    }
}
