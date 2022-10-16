package WeeklyContest_315_16_10_22;

public class LargestPositiveIntegerThatExistsWithItsNegative {
    public int findMaxK(int[] nums) {

        int n = nums.length;
        int max = Integer.MIN_VALUE;

        int[] pos = new int[1001];
        int[] neg = new int[1001];

        for (int i = 0; i < n; ++i) {
            int val = Math.abs(nums[i]);

            if (nums[i] > 0) {
                pos[val]++;
            } else {
                neg[val]++;
            }
        }

        for (int i = 1000; i >= 0; --i) {
            if (pos[i] > 0 && neg[i] > 0) {
                return i;
            }
        }
        return -1;
    }
}
