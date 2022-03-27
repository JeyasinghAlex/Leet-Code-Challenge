public class NextGreaterElement_III {

    public int nextGreaterElement(int a) {

        char[] arr = String.valueOf(a).toCharArray();
        int n = arr.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = arr[i] - '0';
        }

        // case 1:
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            --i;
        }

        if (i == -1) {
            return -1;
        }

        int j = n - 1;
        while (nums[i] >= nums[j]) {
            --j;
        }

        swap(nums, i, j);
        reverse(nums, i + 1, n - 1);
        long ans = getVal(nums);
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;

    }

    private Long getVal(int[] nums) {
        long ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            ans = (ans * 10) + nums[i];
        }
        return ans;
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            ++l;
            --r;
        }
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[j] ^ nums[i];
        nums[i] = nums[i] ^ nums[j];
    }
}
