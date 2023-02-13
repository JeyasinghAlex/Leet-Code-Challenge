package WeeklyContest_332_12_02_23;

public class FindTheArrayConcatenationValue {

    public long findTheArrayConcVal(int[] nums) {

        int n = nums.length;
        long ans = 0l;

        for (int i = 0; i < n / 2; ++i) {
            String s = nums[i] + "" + nums[n - i - 1];
            ans += Long.parseLong(s);
        }

        if (n % 2 == 1) {
            ans += nums[n / 2];
        }
        return ans;
    }
}
