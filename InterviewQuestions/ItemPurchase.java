package InterviewQuestions;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * PayPal
 */
public class ItemPurchase {

    public long findMinimumPrice(List<Integer> price, int m) {

        Queue<Integer> pq = new PriorityQueue<>();
        for (int p : price) {
            pq.offer(p);
        }

        while ((m > 0) && !pq.isEmpty() && (pq.peek() > 0)) {
            int top = pq.peek();
            pq.poll();
            top >>= 1;
            pq.offer(top);
            --m;
        }

        long totalPrice = 0;
        while (!pq.isEmpty()) {
            totalPrice += pq.peek();
            pq.poll();
        }
        return totalPrice;
    }
}
