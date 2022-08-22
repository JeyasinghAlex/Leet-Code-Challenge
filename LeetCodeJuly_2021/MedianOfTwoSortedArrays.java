public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int lo = 0;
        int hi = n1;

        while (lo <= hi) {

            int cut1 = lo + hi >>> 1;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int r1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];

            if (l1 <= r2 && l2 <= r1) {

                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            }

            if (l1 > r2) {
                hi = cut1 - 1;
            } else {
                lo = cut1 + 1;
            }
        }
        return 0.0;
    }

    public double findMedianSortedArrays_1(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int[] temp = new int[n + m];
        merge(temp, nums1, nums2);
        int mid = n + m >>> 1;
        if ((m + n) % 2 == 1 || (n + m) == 1) {
            return (double) temp[mid];
        }
        return ((double) (temp[mid] + temp[mid - 1]) / 2);

    }

    private void merge(int[] nums, int[] left, int[] right) {

        int i = 0;
        int j =  0;
        int k = 0;
        while (i < left.length && j < right.length) {

            if (left[i] <= right[j]) {
                nums[k++] = left[i++];
            } else {
                nums[k++] = right[j++];
            }
        }

        while (i < left.length) {
            nums[k++] = left[i++];
        }
        while (j < right.length) {
            nums[k++] = right[j++];
        }
    }
}
