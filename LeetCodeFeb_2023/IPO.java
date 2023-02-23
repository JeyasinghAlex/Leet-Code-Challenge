import java.util.PriorityQueue;
import java.util.Queue;

public class IPO {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Queue<int[]> pqCap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        Queue<int[]> pqPro = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

        for (int i = 0; i < Profits.length; i++) {
            pqCap.add(new int[] {Capital[i], Profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!pqCap.isEmpty() && pqCap.peek()[0] <= W) {
                pqPro.add(pqCap.poll());
            }

            if (pqPro.isEmpty()) break;

            W += pqPro.poll()[1];
        }

        return W;
    }
}
