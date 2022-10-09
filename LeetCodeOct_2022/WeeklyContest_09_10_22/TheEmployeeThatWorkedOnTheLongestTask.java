package WeeklyContest_09_10_22;

public class TheEmployeeThatWorkedOnTheLongestTask {

    public int hardestWorker(int n, int[][] logs) {

        int prev = 0;
        int maxTime = 0;
        int ans = 0;

        for (int[] log : logs) {

            int time = log[1] - prev;
            prev = log[1];

            if (time > maxTime || (time == maxTime && log[0] < ans)) {
                maxTime = time;
                ans = log[0];
            }
        }
        return ans;
    }
}
