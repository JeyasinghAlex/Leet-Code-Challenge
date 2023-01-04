package BiWeeklyContest_94_24_12_22;

public class MaximumEnemyFortsThatCanBeCaptured {

    public int captureForts(int[] forts) {
        int result = 0, x = 0;
        for (int j = 0; j < forts.length; j++) {
            if (forts[j] != 0) {
                if (forts[x] == -forts[j])
                    result = Math.max(result, j - x - 1);
                x = j;
            }
        }
        return result;
    }
}
