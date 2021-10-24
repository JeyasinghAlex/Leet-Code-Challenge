import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumNumberOfCoinsYouCanGet {

    public int maxCoins(int[] piles) {

        int n = piles.length;
        Arrays.sort(piles);
        int ans = 0;
        for (int i = n / 3; i < n; i += 2) {
            ans += piles[i];
        }
        return ans;
    }

    public int maxCoins_1(int[] piles) {

        Queue<Integer> ace = new PriorityQueue<>();
        Queue<Integer> dec = new PriorityQueue<>((a, b) -> b - a);

        for (int n : piles) {
            ace.offer(n);
            dec.offer(n);
        }

        int n = piles.length;
        int count = 0;
        int ans = 0;
        while (n > count) {
            int a = dec.poll();
            ans += dec.poll();
            ace.poll();
            count += 3;
        }
        return ans;
    }
}
