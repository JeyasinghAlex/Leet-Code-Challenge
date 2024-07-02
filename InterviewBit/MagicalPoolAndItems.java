package InterviewBit;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MagicalPoolAndItems {

    public int solve(int[][] A) {

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Map<Integer, Long> map = new HashMap<>();

        int n = A.length;
        long ans = 0;
        int MOD = 1000000007;

        for (int[] a : A) {

            int key = a[0];
            if (map.containsKey(key)) {
                long max = Math.max(map.get(key), a[1]);
                map.put(key, max);
                continue;
            }
            map.put(a[0], (long)a[1]);
            pq.offer(a[0]);
        }

        while (!pq.isEmpty()) {

            int quantity = pq.poll();
            if (quantity == 0)
                break;

            long max = map.get(quantity);

            int nQuality = (int) Math.floor(quantity / 2);
            long nQuantity = quantity * 2;

            if (map.containsKey(nQuality)) {
                long m = Math.max(map.get(nQuality), nQuantity);
                map.put(nQuality, m);
            }
            else {
                pq.offer(nQuality);
                map.put(nQuality, nQuantity);
            }
            ans = (ans + max) % MOD;
        }
        return (int) ans;
    }
}
