import java.util.Arrays;

public class MinimumNumberOfRemovalsToMakeMountainArray {

    public int minimumMountainRemovals(int[] nums) {

        int n = nums.length;
        int[] lisL = new int[n];
        int[] lisR = new int[n];
        Arrays.fill(lisL, 1);
        Arrays.fill(lisR, 1);

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j] && lisL[i] < lisL[j] + 1) {
                    lisL[i] = lisL[j] + 1;
                }
            }
        }

        for (int i = n - 2; i >= 0; --i) {
            for (int j = n - 1; j > i; --j) {
                if (nums[i] > nums[j] && lisR[i] < lisR[j] + 1) {
                    lisR[i] = lisR[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            if (lisL[i] > 1 && lisR[i] > 1) {
                max = Math.max(max, lisL[i] + lisR[i]);
            }
        }
        return n - (max - 1);
    }
}
