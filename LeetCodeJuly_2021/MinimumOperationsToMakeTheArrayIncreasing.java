public class MinimumOperationsToMakeTheArrayIncreasing {


    public int minOperations(int[] nums) {

        int prev = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= prev) {
                ans += ++prev - nums[i];
                nums[i] = prev;
            }
            prev = nums[i];
        }
        return ans;
    }

    public int minOperations_1(int[] nums) {

        int max = Integer.MIN_VALUE;
        int ans = 0;

        for (int i = 1; i < nums.length; ++i) {

            max =  Math.max(nums[i - 1] + 1, nums[i]);
            if (max != nums[i]) {
                ans += max - nums[i];
            }
            nums[i] = max;
        }
        return ans;
    }
}
