import java.util.PriorityQueue;
import java.util.Queue;

public class RemoveStonesToMinimizeTheTotal {

    public int minStoneSum(int[] piles, int k) {

        Queue<Integer> qu = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int n : piles) {
            qu.offer(n);
            sum += n;
        }

        while (k-- > 0) {
            int temp = qu.poll();
            qu.offer(temp - temp / 2);
            sum -= temp / 2;
        }
        return sum;
    }
}
