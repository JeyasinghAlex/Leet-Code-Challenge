public class MonotonicArray {

    public boolean isMonotonic(int[] nums) {

        boolean isInc = true;
        boolean isDec = true;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                isDec = false;
            }

            if (nums[i - 1] > nums[i]) {
                isInc = false;
            }
        }

        return isInc || isDec;
    }
}
