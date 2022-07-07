public class RearrangeArrayElementsBySign {

    public int[] rearrangeArray(int[] nums) {

        int len = nums.length;
        int[] ans = new int[len];
        int p = 0;
        int n = 1;

        for (int i = 0; i < len; ++i) {

            if (nums[i] > 0) {
                ans[p] = nums[i];
                p = p + 2;
            } else if (nums[i] < 0) {
                ans[n] = nums[i];
                n = n + 2;
            }
        }
        return ans;
    }


    public int[] rearrangeArray_1(int[] nums) {

        int n = nums.length;
        int i = 0;
        int j = 0;
        int[] ans = new int[n];
        int idx = 0;

        while (i < n || j < n) {

            while (i < n && nums[i] <= 0) {
                ++i;
            }

            while (j < n && nums[j] >= 0) {
                ++j;
            }

            if (i < n) {
                ans[idx++] = nums[i];
            }
            if (j < n) {
                ans[idx++] = nums[j];
            }
            ++i;
            ++j;
        }
        return ans;
    }
}
