package Arrays;

/**
 * Inversion of Array (Pre-req: Merge Sort)
 */
public class CountInversions {

    public long getInversions(long arr[], int n) {
        sort(arr);
        return ans;
    }

    private int ans = 0;
    private void sort(long[] nums) {

        int n = nums.length;
        if (n <= 1)
            return ;

        int mid = n >>> 1;
        long[] left = new long[mid];
        long[] right = new long[n - mid];

        for (int i = 0; i < mid; ++i)
            left[i] = nums[i];

        for (int i = mid; i < n; ++i)
            right[i - mid] = nums[i];

        sort(left);
        sort(right);
        merge(nums, left, right);
    }

    private void merge(long[] nums, long[] left, long[] right) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                nums[k++] = left[i++];
            } else {
                nums[k++] = right[j++];
                ans += (left.length - i);
            }
        }

        while (i < left.length)
            nums[k++] = left[i++];

        while (j < right.length)
            nums[k++] = right[j++];

    }
}
