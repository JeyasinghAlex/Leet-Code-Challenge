import java.util.PriorityQueue;
import java.util.Queue;

public class TestMain {

    public static void main(String[] args) {

        int[][] arr = {{1, 2}, {1, 1}, {2, 3}};
        System.out.println(solve(arr));

    }

    public static int solve(int[][] A) {

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int n = A.length;
        int ans = 0;
        int MOD = 1000000007;

        for (int[] a : A)
            pq.offer(a);

        while (!pq.isEmpty()) {


            int[] temp = pq.poll();
            int cnt = 0;
            int max = temp[1];
            if (temp[0] == 0)
                break;

            while (!pq.isEmpty() && temp[0] == pq.peek()[0]) {
                ++cnt;
                max = Math.max(max, pq.poll()[1]);
            }
            if (cnt > 0) {
                int quality = (int) Math.floor(temp[0] / 2);
                int quantity = temp[0] * 2;

                pq.offer(new int[]{quality, quantity});
            }

            ans += max % MOD;
        }
        return ans;
    }
}
