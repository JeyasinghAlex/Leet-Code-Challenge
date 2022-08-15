import java.util.Arrays;

public class JobSequencingProblem {

    class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);

        int max = 0;
        for (Job job : arr) {
            max = Math.max(max, job.deadline);
        }

        int[] slot = new int[max + 1];
        Arrays.fill(slot, -1);

        int count = 0;
        int profit = 0;

        for (int i = 0; i < n; ++i) {
            Job job = arr[i];
            int d = job.deadline;
            int p = job.profit;

            for (int j = d; j > 0; --j) {

                if (slot[j] == -1) {
                    slot[j] = i;
                    ++count;
                    profit += p;
                    break;
                }
            }
        }

        return new int[]{count, profit};
    }

    public int jobScheduling_1(int[][] jobs) {

        Arrays.sort(jobs, (a, b) -> b[1] - a[1]);

        int maxDeadLine = 0;
        for (int[] job : jobs) {
            maxDeadLine = Math.max(maxDeadLine, job[0]);
        }

        int[] profit = new int[maxDeadLine + 1];

        for (int[] job : jobs) {
            int d = job[0];
            int p = job[1];

            while (d > 1 && profit[d] != 0) {
                --d;
            }
            if (profit[d] == 0)
                profit[d] = p;
        }

        int ans = 0;
        for (int i = 0; i <= maxDeadLine; ++i) {
            ans += profit[i];
        }
        return ans;
    }

}
