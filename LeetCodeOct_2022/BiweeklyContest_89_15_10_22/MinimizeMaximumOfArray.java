package BiweeklyContest_89_15_10_22;

public class MinimizeMaximumOfArray {

    public int minimizeArrayValue(int[] nums) {

        int n = nums.length;

        int lo = 0;
        int hi = (int) 1e9;

        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (isPossible(nums, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean isPossible(int[] arr, int target) {

        long x = 0;

        for (int i = 0; i < arr.length; ++i) {
            x = x + target - arr[i];
            if (x < 0) {
                return false;
            }
        }
        return true;
    }
}
