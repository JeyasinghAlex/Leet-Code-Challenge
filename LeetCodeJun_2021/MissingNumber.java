public class MissingNumber {

    public int missingNumber(int[] nums) {

        int total = nums.length;
        total = (total * (total + 1)) / 2;
        for (int i = 1; i < nums.length; ++i) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return total - nums[nums.length - 1];
    }

    public int missingNumber_1(int[] nums) {

        int total = 1;
        for (int i = 1; i < nums.length; ++i) {
            total += i + 1;
            nums[i] = nums[i] + nums[i - 1];
        }
        return total - nums[nums.length - 1];
    }
}
