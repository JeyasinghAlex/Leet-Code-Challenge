package WeeklyContest_302_17_07_22;

public class MaximumNumberOfPairsInArray {

    public int[] numberOfPairs(int[] nums) {

        int n = nums.length;
        int[] arr = new int[101];
        for (int num : nums) {
            arr[num]++;
        }

        int pair = 0;
        int leftover = 0;
        for (int i = 0; i < arr.length; ++i) {
            pair += arr[i] / 2;
            if (arr[i] % 2 == 1) {
                ++leftover;
            }
        }
        return new int[]{pair, leftover};
    }
}
