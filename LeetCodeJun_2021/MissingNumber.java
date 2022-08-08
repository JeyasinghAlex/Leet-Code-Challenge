public class MissingNumber {

    public int missingNumber_bit(int[] nums) {

        int total = 0;
        for (int i = 0; i <= nums.length; ++i) {
            total = total ^ i;
        }

        for (int i = 0; i < nums.length; ++i) {
            total = total ^ nums[i];
        }

        return total;
    }
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
