public class ReversePairs {

    public int reversePairs(int[] nums) {

        sort(nums);
        return ans;
    }

    private void sort(int[] nums) {

        int n = nums.length;

        if (n <= 1) {
            return ;
        }

        int mid = n >>> 1;

        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; ++i) {
            left[i] = nums[i];
        }
        for (int i = mid; i < n; ++i) {
            right[i - mid] = nums[i];
        }

        sort(left);
        sort(right);
        merge(nums, left, right);
    }

    private int ans = 0;
    private void merge(int[] nums, int[] left, int[] right) {

        int i = 0;
        int j = 0;
        int k = 0;

        for (i = 0; i < left.length; ++i) {
            while (j < right.length && left[i] > (2 * (long) right[j])) {
                ++j;
            }
            ans += j;
        }

        i = 0;
        j = 0;
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
