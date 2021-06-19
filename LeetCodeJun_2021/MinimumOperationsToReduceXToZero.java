public class MinimumOperationsToReduceXToZero {

    public int minOperations(int[] nums, int x) {

        int sum = 0;
        for (int a : nums) {
            sum += a;
        }
        sum = sum - x;
        if (sum == 0) {
            return nums.length;
        }
        if (sum < 0) {
            return -1;
        }
        int st = 0;
        int curSum = 0;
        int len = -1;
        for (int ed = 0; ed < nums.length; ++ed) {

            curSum += nums[ed];
            while (curSum >= sum) {

                if (curSum == sum) {
                    len = Math.max(len, ed - st + 1);
                }

                curSum -= nums[st++];
            }
        }
        return len == -1  ? -1 : nums.length - len;
    }
}
