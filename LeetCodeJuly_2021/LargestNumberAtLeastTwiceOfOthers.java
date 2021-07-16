public class LargestNumberAtLeastTwiceOfOthers {

    public int dominantIndex(int[] nums) {

        int max = 0;
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        for (int n : nums) {

            if (n == 0 || n == max) continue;

            if (max / n <= 1) {
                return -1;
            }
        }
        return index;
    }
}
