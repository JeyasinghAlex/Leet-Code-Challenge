public class LongestAlternatingSubSequence {

    public int AlternatingaMaxLength(int[] nums) {
        int n = nums.length;
        int incr = 1;
        int decr = 1;
        int max = 1;
        for (int i = 1; i < n; ++i) {

            if (nums[i] > nums[i - 1]) {
                incr = decr + 1;
            } else if (nums[i] < nums[i - 1]) {
                decr = incr + 1;
            }
            max = Math.max(incr, decr);
        }
        return max;
    }
}
