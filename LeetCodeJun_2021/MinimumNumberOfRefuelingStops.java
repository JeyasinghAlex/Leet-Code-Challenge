import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingStops {

    public int minRefuelStops(int target, int tank, int[][] stations) {

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
