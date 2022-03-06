public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = nums[0];
        rightMax[n - 1] = nums[n - 1];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = (i % k == 0) ? nums[i] : Math.max(leftMax[i - 1], nums[i]);
            int j = n - i - 1;
            rightMax[j] = ((j + 1) % k == 0) ? nums[j] : Math.max(rightMax[j + 1], nums[j]);
        }

        int size = n - k + 1;
        int[] ans = new int[size];
        for (int i = 0; i < size; ++i) {
            ans[i] = Math.max(leftMax[k + i - 1], rightMax[i]);
        }
        return ans;
    }
}
