import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumNumberOfRefuelingStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        if (startFuel >= target) {
            return 0;
        }

        int n = stations.length;

        Queue<Integer> qu = new PriorityQueue<>((a, b) -> b - a);

        int i = 0;
        int maxDis = startFuel;
        int stop = 0;

        while (maxDis < target) {

            while (i < n && stations[i][0] <= maxDis) {
                qu.offer(stations[i++][1]);
            }

            if (qu.isEmpty()) {
                return -1;
            }

            maxDis += qu.poll();
            stop++;
        }
        return stop;
    }

    public int minRefuelStops_1(int target, int tank, int[][] stations) {

        PriorityQueue<Integer> qu = new PriorityQueue<>((a, b) -> b - a);

        int prevStation = 0;
        int count = 0;

        for (int[] arr : stations) {

            tank -= arr[0] - prevStation;

            while (!qu.isEmpty() && tank < 0) {
                tank += qu.poll();
                ++count;
            }

            if (tank < 0) {
                return -1;
            }
            prevStation = arr[0];
            qu.offer(arr[1]);
        }

        tank -= target - prevStation;
        while (!qu.isEmpty() && tank < 0) {
            tank += qu.poll();
            ++count;
        }

        if (tank < 0) {
            return -1;
        }

        return count;
    }
}
