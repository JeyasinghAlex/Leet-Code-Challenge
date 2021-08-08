public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
        }

        if ((sum & 1) == 1 || nums.length == 1) return false;

        int half = sum / 2;
        Boolean[][] memo = new Boolean[nums.length][half + 1];
        return helper(nums, 0, half, memo);

    }

    private boolean helper(int[] nums, int index, int target, Boolean[][] memo) {

        if (target == 0) {
            return true;
        }

        if (nums.length == index || target < 0) {
            return false;
        }

        if (memo[index][target] != null) {
            return memo[index][target];
        }

        memo[index][target] = helper(nums, index + 1, target, memo) || helper(nums, index + 1, target - nums[index], memo);
        return memo[index][target];

    }
}
