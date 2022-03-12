public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        int idx = 0;
        while (idx < n) {
            if (nums[idx] > 0 && nums[idx] <= n && nums[idx] != nums[nums[idx] - 1]) {
                swap(idx, nums[idx] - 1, nums);
            } else {
                ++idx;
            }
        }

        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private void swap(int x, int y, int[] nums) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
