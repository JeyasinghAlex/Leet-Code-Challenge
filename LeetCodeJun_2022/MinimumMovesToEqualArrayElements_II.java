import java.util.Arrays;

public class MinimumMovesToEqualArrayElements_II {

    public int minMoves2(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        int j = n - 1;
        int ans = 0;
        while (i < j) {
            ans += nums[j] - nums[i];
            ++i;
            --j;
        }
        return ans;
    }

    public int minMoves2_1(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        int median = nums[n / 2];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.abs(nums[i] - median);
        }
        return ans;
    }
}
