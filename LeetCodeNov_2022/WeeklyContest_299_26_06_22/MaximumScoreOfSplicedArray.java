package WeeklyContest_299_26_06_22;

public class MaximumScoreOfSplicedArray {

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int sum1 = 0;
        int sum2 = 0;
        int[] d1 = new int[n];
        int[] d2 = new int[n];


        int s1 = 0;
        int s2 = 0;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; ++i) {
            sum1 += nums1[i];
            sum2 += nums2[i];

            s1 += nums1[i] - nums2[i];
            s2 += nums2[i] - nums1[i];

            max1 = Math.max(max1, s1);
            max2 = Math.max(max2, s2);

            if (s1 < 0) {
                s1 = 0;
            }

            if (s2 < 0) {
                s2 = 0;
            }
        }

        int max = Math.max(sum1 + max2, sum2 + max1);
        return max;
    }

    public int maximumsSplicedArrayUsingExtraSpace(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int sum1 = 0;
        int sum2 = 0;
        int[] d1 = new int[n];
        int[] d2 = new int[n];

        for (int i = 0; i < n; ++i) {
            sum1 += nums1[i];
            sum2 += nums2[i];
            d1[i] = nums1[i] - nums2[i];
            d2[i] = nums2[i] - nums1[i];
        }

        int s1 = 0;
        int s2 = 0;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; ++i) {
            s1 += d1[i];
            s2 += d2[i];
            if (s1 < 0) {
                s1 = 0;
            }
            if (s2 < 0) {
                s2 = 0;
            }
            max1 = Math.max(max1, s1);
            max2 = Math.max(max2, s2);
        }

        int max = Math.max(sum1 + max2, sum2 + max1);
        return max;
    }
}
