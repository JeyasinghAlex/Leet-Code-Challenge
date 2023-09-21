package DynamicProgramming;

public class MaxProductSubArray {

    public int maxProduct(int[] nums) {

        int n = nums.length;
        int pre = 1;
        int suff = 1;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            pre = pre * nums[i];
            max = Math.max(max, pre);
            if (pre == 0)
                pre = 1;

            suff = suff * nums[n - i - 1];
            max = Math.max(max, suff);
            if (suff == 0)
                suff = 1;
        }

        return max;
    }

    public int maxProduct_1(int[] nums) {

        int n = nums.length;
        int prod = 1;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            prod = prod * nums[i];
            max = Math.max(max, prod);
            if (prod == 0)
                prod = 1;
        }

        prod = 1;
        for (int i = n - 1; i >= 0; --i) {
            prod = prod * nums[i];
            max = Math.max(max, prod);
            if (prod == 0)
                prod = 1;
        }

        return max;
    }
}
