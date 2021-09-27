import java.util.Arrays;

public class BestTeamWithNoConflicts {

    public int bestTeamScore(int[] scores, int[] ages) {

        int n = scores.length;
        int[][] players = new int[n][2];
        for (int i = 0; i < n; ++i) {
            players[i][0] = ages[i];
            players[i][1] = scores[i];
        }

        Arrays.sort(players, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int[] msis = new int[n];
        for (int i = 0; i < n; ++i){
            msis[i] = players[i][1];
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (players[i][1] >= players[j][1] && msis[i] < msis[j] + players[i][1]) {
                    msis[i] = msis[j] + players[i][1];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, msis[i]);
        }
        return max;
    }
}
