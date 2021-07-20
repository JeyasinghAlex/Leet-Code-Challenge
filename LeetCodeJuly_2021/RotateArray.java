public class RotateArray {

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }

    public void rotate_1(int[] nums, int k) {

        int n = nums.length;
        int[] temp = new int[n];
        k = k % n;
        if (k == 0) {
            return;
        }

        for (int i = 0; i < n; ++i) {
            temp[i] = nums[(n - k + i) % n];
        }

        for (int i = 0; i < n; ++i) {
            nums[i] = temp[i];
        }
    }
}
