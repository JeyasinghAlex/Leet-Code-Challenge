package GreedyAlgorithm;

import java.util.*;

public class JobSequencingProblem {

    public int jobScheduling(int[][] arr) {

        int n = arr.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; ++i) {
            int[] job = arr[i];
            jobs[i] = new Job(job[0], job[1], job[2]);
        }

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int max = 0;
        int profit = 0;
        int cnt = 0;
        for (int i = 0; i < n; ++i)
            max = Math.max(max, jobs[i].deadLine);

        int[] slots = new int[max + 1];

        for (int i = 0; i < n; ++i) {
            Job job = jobs[i];
            int d = job.deadLine;
            int p = job.profit;

            for (int j = d; j > 0; --j) {
                if (slots[j] == 0) {
                    slots[i] = i;
                    profit += p;
                    cnt++;
                    break;
                }
            }
        }
        return profit;
    }
}

class Job {
    int id;
    int deadLine;
    int profit;

    public Job(int id, int deadLine, int profit) {
        this.id = id;
        this.deadLine = deadLine;
        this.profit = profit;
    }
}
