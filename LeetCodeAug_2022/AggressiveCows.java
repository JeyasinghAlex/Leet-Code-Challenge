import java.util.Arrays;

public class AggressiveCows {

    public int aggressiveCows(int[] positions, int cows) {
        // Write your code here.
        Arrays.sort(positions);

        int n = positions.length;
        int ans = -1;

        int lo = 1;
        int hi = positions[n - 1] - positions[0];

        while (lo <= hi) {

            int mid = lo + hi >>> 1;

            if (isPossible(positions, mid, cows)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] nums, int dis, int cows) {

        int count = 1;
        int st = nums[0];

        for (int i = 1; i < nums.length; ++i) {

            if (nums[i] - st >= dis) {
                ++count;
                st = nums[i];
            }
        }

        if (count >= cows) {
            return true;
        }
        return false;
    }
}
