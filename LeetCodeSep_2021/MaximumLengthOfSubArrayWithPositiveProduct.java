public class MaximumLengthOfSubArrayWithPositiveProduct {

    public int getMaxLen(int[] nums) {

        int max = 0;
        int count = 0;
        boolean flag = false;
        int negative = 0;

        for (int i = 0; i < nums.length; ++i) {

            ++count;

            if (nums[i] < 0) {
                ++negative;
            }

            flag = negative % 2 == 0;

            if (nums[i] == 0) {
                count = 0;
                negative = 0;
            }
            if (flag) {
                max = Math.max(max, count);
            }
        }

        count = 0;
        negative = 0;

        for (int i = nums.length - 1; i >= 0; --i) {

            ++count;

            if (nums[i] < 0) {
                ++negative;
            }

            flag = negative % 2 == 0;

            if (nums[i] == 0) {
                count = 0;
                negative = 0;
            }


            if (flag) {
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
