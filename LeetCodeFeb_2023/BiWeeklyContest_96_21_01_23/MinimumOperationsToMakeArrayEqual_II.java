package BiWeeklyContest_96_21_01_23;

public class MinimumOperationsToMakeArrayEqual_II {

    public long minOperations(int[] nums1, int[] nums2, double k) {
        long count = 0, sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != nums2[i] && (k == 0 || (nums1[i] - nums2[i]) % k != 0)) {
                return -1;
            }
            count += Math.max(0, (nums1[i] - nums2[i]) / k);
            sum += nums1[i] - nums2[i];
        }
        return sum == 0 ? count : -1;
    }
}
