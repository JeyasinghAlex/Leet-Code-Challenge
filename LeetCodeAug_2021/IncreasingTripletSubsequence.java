import java.util.Arrays;

public class IncreasingTripletSubsequence {


    public boolean increasingTriplet(int[] nums) {

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int n : nums) {

            if (n <= first) {
                first = n;
            } else if (n <= second) {
                second = n;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean increasingTriplet_1(int[] nums) {

        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int n : nums) {
            int index = lowerBond(dp, n);
            dp[index] = n;
            if (index >= 2) {
                return true;
            }
        }
        return false;
    }

    private int lowerBond(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {

            int mid = lo + hi >>> 1;
            if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
