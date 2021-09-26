public class MaximumSumIncreasingSubSequence {

    public static void main(String[] args) {
        int[] arr = {1, 100, 3, 2, 6};
        System.out.println(new MaximumSumIncreasingSubSequence().maximumSumIncreasingSubSequence(arr));
    }

    public int maximumSumIncreasingSubSequence(int[] nums) {

        int n = nums.length;
        int[] msis = new int[n];
        for (int i = 0; i < n; ++i) {
            msis[i] = nums[i];
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j] && msis[i] < nums[i] + msis[j]) {
                    msis[i] = nums[i] + msis[j];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; ++i) {
            max = Math.max(max, msis[i]);
        }
        return max;
    }
}
