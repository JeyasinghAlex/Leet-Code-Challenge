public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {

        int i = 0;
        int j = nums.length - 1;
        int k = j;
        int[] ans = new int[k + 1];
        while (i <= j) {

            int a = nums[i] * nums[i];
            int b = nums[j] * nums[j];

            if (a > b) {
                ans[k--] = a;
                ++i;
            } else {
                ans[k--] = b;
                --j;
            }
        }
        return ans;
    }
}
