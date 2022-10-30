package BiWeeklyContest_83_23_07_22;

import java.util.Arrays;

public class ShortestImpossibleSequenceOfRolls {

    public int shortestSequence(int[] rolls, int k) {

        int n = rolls.length;
        boolean[] visited = new boolean[k + 1];
        int ans = 1;
        int cnt = 0;

        for (int i = 0; i < n; ++i) {

            int num = rolls[i];
            if (!visited[num]) {
                visited[num] = true;
                ++cnt;
                if (cnt == k) {
                    ++ans;
                    Arrays.fill(visited, false);
                    cnt = 0;
                }
            }
        }
        return ans;
    }
}
