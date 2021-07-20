public class SortAnArray {

    public int[] sortArray(int[] nums) {
        sort(nums);
        return nums;
    }

    private void sort(int[] nums) {

        int n = nums.length;
        if (n < 2) {
            return ;
        }
        int lo = 0;
        int hi = nums.length;
        int mid = lo + hi >>> 1;

        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; ++i)
            left[i] = nums[i];
        for (int i = mid; i < n; ++i)
            right[i - mid] = nums[i];
        sort(left);
        sort(right);
        merge(nums, left, right);
    }

    private void merge(int[] nums, int[] left, int[] right) {

        int i = 0;
        int j = 0;
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
