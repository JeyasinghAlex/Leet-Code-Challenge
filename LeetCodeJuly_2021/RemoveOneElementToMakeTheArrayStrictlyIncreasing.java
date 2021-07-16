public class RemoveOneElementToMakeTheArrayStrictlyIncreasing {

    public boolean canBeIncreasing(int[] nums) {
        boolean flag = false;
        for (int i = 1; i < nums.length; ++i) {

            if (nums[i] <= nums[i - 1]) {
                if (flag) return false;
                flag = true;
                if (i > 1 && nums[i] <= nums[i - 2]) {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return true;
    }
}