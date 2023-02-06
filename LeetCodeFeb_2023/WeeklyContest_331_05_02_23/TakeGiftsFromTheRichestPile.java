package WeeklyContest_331_05_02_23;

import java.util.PriorityQueue;
import java.util.Queue;

public class TakeGiftsFromTheRichestPile {

    public long pickGifts(int[] gifts, int k) {

        int n = gifts.length;
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int gift : gifts) {
            pq.offer(gift);
        }

        while (k-- > 0) {
            int peek = pq.poll();
            int sqr = (int) Math.sqrt(peek);
            pq.offer(sqr);
        }

        long ans = 0l;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }
}
