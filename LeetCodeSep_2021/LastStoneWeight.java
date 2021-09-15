import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        Queue<Integer> qu = new PriorityQueue<>((a, b) -> b - a);
        for (int n : stones) {
            qu.offer(n);
        }

        while (!qu.isEmpty() && qu.size() >= 2) {
            int a = qu.poll();
            int b = qu.poll();
            if (a != b) {
                qu.offer(a - b);
            }
        }
        return qu.isEmpty() ? 0 : qu.poll();
    }
}
