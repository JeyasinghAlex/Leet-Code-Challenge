package BiWeeklyContest_82_07_09_22;

public class MinimumSumOfSquaredDifference {

    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;
        long k = (long) k1 + k2;
        int[] diffs = new int[100001];
        int maxDiff = 0;
        long totalDiff = 0;
        for (int i = 0; i < n; ++i) {
            int currDiff = Math.abs(nums1[i] - nums2[i]);
            if (currDiff > 0) {
                totalDiff += currDiff;
                maxDiff = Math.max(maxDiff, currDiff);
                diffs[currDiff]++;
            }
        }

        if (totalDiff <= k) {
            return 0;
        }

        for (int i = maxDiff; i > 0; --i) {
            if (diffs[i] > 0) {
                if (k >= diffs[i]) {
                    diffs[i - 1] += diffs[i];
                    k -= diffs[i];
                    diffs[i] = 0;
                } else {
                    diffs[i - 1] += k;
                    diffs[i] -= k;
                    break;
                }
            }
        }

        long ans = 0L;
        for (int i = 0; i <= maxDiff; ++i) {
            if (diffs[i] > 0) {
                ans += (long) (Math.pow((long)i, 2)) * diffs[i];
            }
        }
        return ans;
    }
}
