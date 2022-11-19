package BiWeeklyContest_78_14_05_22;

import java.util.Arrays;

public class MaximumWhiteTilesCoveredByCarpet {

    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {

        int n = tiles.length;
        int ans = 0;
        int j = 0;
        int cover = 0;

        Arrays.sort(tiles, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < n && ans < carpetLen; ) {

            if (tiles[j][0] + carpetLen > tiles[i][1]) {
                cover += (tiles[i][1] - tiles[i][0] + 1);
                ans = Math.max(ans, cover);
                ++i;
            } else {
                int partial = Math.max(0, tiles[j][0] + carpetLen - tiles[i][0]);
                ans = Math.max(ans, cover + partial);
                cover -= (tiles[j][1] - tiles[j][0] + 1);
                ++j;
            }
        }
        return ans;
    }
}
