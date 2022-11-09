package BiWeeklyContest_80_11_06_22;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];

        Arrays.sort(potions);

        for (int i = 0; i < n; ++i) {
            int idx = lowerBond(spells[i], potions, success);
            ans[i] = m - idx;
        }
        return ans;
    }


    private int lowerBond(long prod, int[] nums, long target) {

        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = lo + hi >>> 1;
            long val = (long) (prod * nums[mid]);
            if (target > val) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
