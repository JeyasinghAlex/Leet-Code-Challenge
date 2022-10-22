package WeeklyContest_305_07_08_22;

public class CheckIfThereIsValidPartitionForTheArray {

    public boolean validPartition(int[] nums) {

        int n = nums.length;
        Boolean[] memo = new Boolean[n];
        return isValidPartition(nums, memo, 0);
    }

    private boolean isValidPartition(int[] nums, Boolean[] memo, int idx) {

        if (idx == nums.length)
            return true;

        if (memo[idx] != null)
            return memo[idx];

        boolean a = false;
        boolean b = false;
        boolean c = false;

        if (idx < nums.length - 1 && nums[idx] == nums[idx + 1])
            a = isValidPartition(nums, memo, idx + 2);

        if (idx < nums.length - 2 && (nums[idx] == nums[idx + 1]) && (nums[idx] == nums[idx + 2]))
            b = isValidPartition(nums, memo, idx + 3);

        if (idx < nums.length - 2 && (nums[idx + 2] - nums[idx + 1] == 1) && (nums[idx + 1] - nums[idx] == 1))
            c = isValidPartition(nums, memo, idx + 3);

        memo[idx] = a || b || c;
        return memo[idx];
    }
}
