package WeeklyContest_293_15_05_22;

public class LargestCombinationWithBitwiseANDGreaterThanZero {

    public int largestCombination(int[] candidates) {

        int n = candidates.length;

        int ans = 0;

        int[] bitCnt = new int[32];

        for (int i = 0; i < n; ++i) {
            int num = candidates[i];
            for (int j = 0; num != 0; num >>>= 1, ++j) {
                if ((num & 1) == 1) {
                    bitCnt[j]++;
                }
            }
        }

        for (int i = 0; i < 32; ++i) {
            ans = Math.max(ans, bitCnt[i]);
        }
        return ans;
    }
}
