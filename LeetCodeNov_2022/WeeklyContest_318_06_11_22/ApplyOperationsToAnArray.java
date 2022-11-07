package WeeklyContest_318_06_11_22;

public class ApplyOperationsToAnArray {

    public int[] applyOperations(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = 2 * nums[i];
                nums[i + 1] = 0;
            }
        }

        int idx = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                nums[idx++] = nums[i];
            }
        }

        for (int i = idx; i < n; ++i) {
            nums[i] = 0;
        }
        return nums;
    }
}
