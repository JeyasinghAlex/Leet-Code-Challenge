import java.util.Arrays;
import java.util.TreeMap;

public class MaximumProfitInJobScheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];

        for(int i = 0; i < n; ++i){
            jobs[i] = new  Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> a.endTime - b.endTime);

        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        tMap.put(0, 0);

        for (int i = 0; i < n; ++i) {

            int sTime = jobs[i].startTime;
            int eTime = jobs[i].endTime;
            int p = jobs[i].profit;

            int value = tMap.floorEntry(sTime).getValue() + p;
            int maxVal = tMap.lastEntry().getValue();

            if (value > maxVal) {
                tMap.put(eTime, value);
            }
        }
        return tMap.lastEntry().getValue();
    }

    public int jobScheduling_1(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        int[] maxProfit = new int[n];

        for(int i = 0; i < n; ++i){
            jobs[i] = new  Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> a.endTime - b.endTime);
        maxProfit[0] = jobs[0].profit;

        for (int i = 1; i < n; ++i) {
            maxProfit[i] = Math.max(maxProfit[i - 1], jobs[i].profit);
            for (int j = i - 1; j >= 0; --j) {
                if (jobs[j].endTime <= jobs[i].startTime) {
                    maxProfit[i] = Math.max(maxProfit[i], maxProfit[j] + jobs[i].profit);
                    break;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, maxProfit[i]);
        }
        return max;
    }
}

class Job {

    int startTime;
    int endTime;
    int profit;

    public Job(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
}
