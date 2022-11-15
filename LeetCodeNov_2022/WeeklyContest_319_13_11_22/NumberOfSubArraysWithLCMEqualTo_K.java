package WeeklyContest_319_13_11_22;

public class NumberOfSubArraysWithLCMEqualTo_K {

    public int subarrayLCM(int[] nums, int k) {

        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int lcm = 1;
            for (int j = i; j < n; ++j) {
                lcm = lcm(lcm, nums[j]);
                if (lcm == k) {
                    ++ans;
                }
                if (lcm > k) {
                    break;
                }
            }
        }
        return ans;
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
