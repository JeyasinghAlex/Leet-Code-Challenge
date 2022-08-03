public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {

            if (nums[i] % 2 == 1 && nums[j] % 2 == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

            if (nums[i] % 2 == 0) {
                ++i;
            }
            if (nums[j] % 2 == 1) {
                --j;
            }
        }
        return nums;
    }

    public int[] sortArrayByParity_1(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        for (int a : nums) {

            if (a % 2 == 0) {
                res[i++] = a;
            } else {
                res[j--] = a;
            }
        }
        return res;
    }
}
