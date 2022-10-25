package BiWeeklyContest_85_20_08_22;

public class MinimumRecolorsToGet_K_ConsecutiveBlackBlocks {

    public int minimumRecolors(String blocks, int k) {

        int n = blocks.length();
        int[] white = new int[n + 1];
        int w = 0;
        for (int i = 0; i < n; ++i) {
            char ch = blocks.charAt(i);
            if (ch == 'W')
                ++w;

            white[i + 1] = w;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n - k; ++i) {
            ans = Math.min(ans, white[i + k] - white[i]);
        }

        return ans;
    }
}
