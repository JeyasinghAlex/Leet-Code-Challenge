public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int[] ans = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; ++i) {
            product *= nums[i];
            ans[i] = product;
        }

        product = 1;
        for (int i = nums.length - 1; i > 0; --i) {
            ans[i] = product * ans[i - 1];
            product *= nums[i];
        }
        ans[0] = product;
        return ans;
    }

    public int[] productExceptSelf_1(int[] nums) {

        int[] product = new int[nums.length];
        product[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            product[i] = product[i - 1] * nums[i];
        }

        int[] ans = new int[nums.length];
        int mul = 1;
        for (int i = nums.length - 1; i >= 0; --i) {

            if(i == 0) {
                ans[i] = mul;
            } else {
                ans[i] = mul * product[i - 1];
            }
            mul *= nums[i];
        }
        return ans;
    }

    public int[] productExceptSelf_2(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; ++i) {
            left[i] = left[i - 1] * nums[i];
        }

        for (int i = nums.length - 2; i >= 0; --i) {
            right[i] = right[i + 1] * nums[i];
        }

        for (int i = 0; i < nums.length; ++i) {

            if (i == 0) {
                nums[i] = right[i + 1];
            } else if (i == nums.length - 1) {
                nums[i] = left[i - 1];
            } else {
                nums[i] = left[i - 1] * right[i + 1];
            }
        }
        return nums;
    }
}