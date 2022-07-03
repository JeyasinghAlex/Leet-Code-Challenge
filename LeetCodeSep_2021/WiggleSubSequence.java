public class WiggleSubSequence {

    public int wiggleMaxLength(int[] nums) {

        int n = nums.length;
        int pos = 1;
        int neg = 1;
        int max = 1;
        for (int i = 1; i < n; ++i) {

            if (nums[i] - nums[i - 1] > 0) {
                pos = neg + 1;
            } else if (nums[i] - nums[i - 1] < 0) {
                neg = pos + 1;
            }
            max = Math.max(pos, neg);
        }
        return max;
    }

    public int wiggleMaxLength_1(int[] nums) {

        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];

        for (int i = 1; i < n; ++i) {

            if (nums[i] - nums[i - 1] > 0) {
                up[i] = 1 + down[i - 1];
                down[i] = down[i - 1];
            } else if (nums[i] - nums[i - 1] < 0) {
                down[i] = 1 + up[i - 1];
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        return 1 + Math.max(up[n - 1], down[n - 1]);
    }
}
