package weekly_10_7_22;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumAmountOfTimeToFillCups {

    public int fillCups(int[] amount) {

        Queue<Integer> qu = new PriorityQueue<>((a, b) -> b - a);

        qu.offer(amount[0]);
        qu.offer(amount[1]);
        qu.offer(amount[2]);
        int step = 0;

        while (!qu.isEmpty() && qu.peek() > 0) {

            int a = qu.poll();
            int b = qu.poll();
            qu.offer(a - 1);
            qu.offer(b - 1);
            ++step;
        }
        return step;
    }

    public int fillCups_(int[] amount) {


        Arrays.sort(amount);
        if (amount[0] + amount[1] <= amount[2]) {
            return amount[2];
        } else {
            int sum = amount[0] + amount[1] + amount[2];
            return (sum + 1) / 2;
        }
    }
}
