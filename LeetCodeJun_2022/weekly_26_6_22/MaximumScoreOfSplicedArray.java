package weekly_26_6_22;

public class MaximumScoreOfSplicedArray {

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {

        return Math.max(getMaximum(nums1, nums2), getMaximum(nums2, nums1));
    }

    private int getMaximum(int[] nums1, int[] nums2) {

        int max = 0;
        int sum = 0;
        int maxDiff = 0;

        for (int i = 0; i < nums1.length; ++i) {
            sum += nums1[i];
            int diff = nums2[i] - nums1[i];
            maxDiff = Math.max(maxDiff, 0) + diff;
            max = Math.max(max, maxDiff);
        }
        return sum + max;
    }
}
