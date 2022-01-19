public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {

        int row = dungeon.length;
        int col = dungeon[0].length;

        for (int i = row - 1; i >= 0; --i) {
            for (int j = col - 1; j >= 0; --j) {
                if (i == row - 1 && j == col - 1) {
                    dungeon[i][j] = Math.min(0, dungeon[i][j]);
                }
                else if (i == row - 1) {
                    dungeon[i][j] = Math.min(0, dungeon[i][j] + dungeon[i][j + 1]);
                }
                else if (j == col - 1) {
                    dungeon[i][j] = Math.min(0, dungeon[i][j] + dungeon[i + 1][j]);
                }
                else {
                    dungeon[i][j] = Math.min(0, dungeon[i][j] + Math.max(dungeon[i + 1][j], dungeon[i][j + 1]));
                }
            }
        }
        return Math.abs(dungeon[0][0]) + 1;
    }
}
