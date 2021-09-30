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
}
