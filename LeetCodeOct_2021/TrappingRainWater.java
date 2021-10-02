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

    public int trap_1(int[] height) {

        int n = height.length;
        if (n <= 2) {
            return 0;
        }

        int i = 1;
        int j = n - 2;
        int leftMax = height[0];
        int rightMax = height[n - 1];
        int ans = 0;

        while (i <= j) {

            if (leftMax < rightMax) {
                if (height[i] > leftMax) {
                    leftMax = height[i];
                } else {
                    ans += leftMax - height[i];
                }
                ++i;
            } else {
                if (height[j] > rightMax) {
                    rightMax = height[j];
                } else {
                    ans += rightMax - height[j];
                }
                --j;
            }
        }
        return ans;
    }
}
