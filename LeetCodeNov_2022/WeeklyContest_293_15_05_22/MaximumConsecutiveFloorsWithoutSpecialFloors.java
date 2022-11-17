package WeeklyContest_293_15_05_22;

import java.util.Arrays;

public class MaximumConsecutiveFloorsWithoutSpecialFloors {

    public int maxConsecutive(int bottom, int top, int[] special) {

        int n = special.length;
        int ans = 0;
        Arrays.sort(special);
        ans = special[0] - bottom;
        for (int i = 1; i < n; ++i) {
            int diff = special[i] - special[i - 1] - 1;
            ans = Math.max(ans, diff);
        }
        ans = Math.max(ans, top - special[n - 1]);
        return ans;
    }
}
