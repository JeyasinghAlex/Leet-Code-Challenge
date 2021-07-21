public class SumOfAbsoluteDifferencesInSortedArray {

    public int[] getSumAbsoluteDifferences(int[] nums) {

        int rSum = 0;
        int lSum = 0;
        int n = nums.length;
        for (int i : nums) {
            rSum += i;
        }

        for (int i = 0; i < n; ++i) {
            rSum -= nums[i];
            lSum += nums[i];
            nums[i] = (rSum - ((n - i - 1) * nums[i])) + (((i + 1) * nums[i]) - lSum);
        }
        return nums;
    }
}
