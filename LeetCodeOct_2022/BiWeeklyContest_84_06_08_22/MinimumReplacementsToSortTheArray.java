package BiWeeklyContest_84_06_08_22;

public class MinimumReplacementsToSortTheArray {

    public long minimumReplacement(int[] nums) {

        long ans = 0;
        int next = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; --i) {
            int cur = nums[i];
            if (cur <= next) {
                next = cur;
                continue;
            }
            int parts = (cur + next - 1) / next;
            next = cur / parts;
            ans += parts - 1;
        }
        return ans;
    }
}
