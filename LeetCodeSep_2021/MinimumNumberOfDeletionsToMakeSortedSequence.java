import java.util.Arrays;

public class MinimumNumberOfDeletionsToMakeSortedSequence {

    public int minimumDeletion(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) {
            int idx = lowerBond(dp, nums[i]);
            dp[idx] = nums[i];
        }
        return n - lowerBond(dp, Integer.MAX_VALUE);
    }

    private int lowerBond(int[] dp, int target) {
        int lo = 0;
        int hi = dp.length;
        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (target > dp[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public int minimumDeletion_1(int[] nums) {

        int n = nums.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        int max = 1;

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    max = Math.max(max, lis[i]);
                }
            }
        }
        return n - max;
    }
}
