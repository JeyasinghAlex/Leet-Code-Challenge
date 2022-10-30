package BiWeeklyContest_83_23_07_22;

public class NumberOfZeroFilledSubArrays {

    public long zeroFilledSubarray(int[] nums) {

        int n = nums.length;

        long cnt = 0L;
        long ans = 0L;
        for (int i = 0; i < n; ++i) {

            if (nums[i] == 0) {
                ++cnt;
                ans += cnt;
            } else {
                cnt = 0;
            }
        }
        return ans;
    }
}
