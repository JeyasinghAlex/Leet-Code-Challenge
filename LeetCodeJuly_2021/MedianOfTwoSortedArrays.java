public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

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
