package BiWeeklyContest_78_14_05_22;

public class FindTheK_BeautyOfNumber {

    public int divisorSubstrings(int num, int k) {

        int pow = (int) Math.pow(10, k);
        int ans = 0;
        for (int n = num; n > 0; n /= 10) {

            int div = n % pow;
            if (div != 0 && num % div == 0) {
                ++ans;
            }
            if (n / pow == 0) {
                break;
            }
        }
        return ans;
    }

    public int divisorSubstrings_1(int num, int k) {

        String s = num + "";
        int ans = 0;
        for (int i = 0; i <= s.length() - k; ++i) {
            int n = Integer.parseInt(s.substring(i, i + k));
            if (n != 0)
                ans += (num % n == 0) ? 1 : 0;
        }
        return ans;
    }
}
