public class PartitionToKEqualSumSubSets {

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        int n = nums.length;
        int target = sum / k;
        boolean[] visited = new boolean[n];
        return dfs(0, nums, target, 0, k, visited);
    }

    private boolean dfs(int index, int[] nums, int target, int sum, int k, boolean[] visited) {

        if (k == 1) {
            return true;
        }

        if (sum == target) {
            return dfs(0, nums, target, 0, k - 1, visited);
        }

        for (int i = index; i < nums.length; ++i) {

            if (!visited[i]) {
                visited[i] = true;

                if (dfs(i + 1, nums, target, sum + nums[i], k, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
