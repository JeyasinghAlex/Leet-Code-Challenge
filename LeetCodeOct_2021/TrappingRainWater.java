public class TrappingRainWater {

    public int trap(int[] height) {

        int n = height.length;
        if (n <= 2) {
            return 0;
        }

        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        int max = 0;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, height[i]);
            maxLeft[i] = max;
        }

        max = 0;
        for (int i = n - 1; i >= 0; --i) {
            max = Math.max(max, height[i]);
            maxRight[i] = max;
        }

        int ans =  0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            min = Math.min(maxLeft[i], maxRight[i]);
            ans += min - height[i];
        }
        return ans;
    }
}
