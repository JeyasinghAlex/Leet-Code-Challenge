package WeeklyContest_316_23_10_22;

public class NumberOfSubArraysWithGCDEqualToK {

    public int subarrayGCD(int[] nums, int k) {

        int n = nums.length;

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int g = 0;
            for (int j = i; j < n; ++j) {
                g = gcd(nums[j], g);
                if (g == k) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
