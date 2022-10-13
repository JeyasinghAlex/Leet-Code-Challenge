package BiWeeklyContest_87_17_09_22;

import java.util.Arrays;

public class MaximumMatchingOfPlayersWithTrainers {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {

        int n = players.length;
        int m = trainers.length;

        Arrays.sort(players);
        Arrays.sort(trainers);

        int j = 0;
        int cnt = 0;

        for (int i = 0; i < n && j < m; ++i) {

            while (j < trainers.length && players[i] > trainers[j]) {
                ++j;
            }
            if (j < trainers.length && players[i] <= trainers[j]) {
                ++cnt;
            }
            ++j;
        }
        return cnt;
    }
}
