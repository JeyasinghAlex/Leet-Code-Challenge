package LeetCode_2024;

import java.util.PriorityQueue;
import java.util.Queue;

public class K_ClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] p : points) {
            int number1 = p[0] * p[0];
            int number2 = p[1] * p[1];

            int sum = number1 + number2;

            pq.offer(new int[]{sum, p[0], p[1]});
        }

        int[][] ans = new int[k][2];
        int idx = 0;
        while (k-- > 0) {
            int[] temp = pq.poll();
            ans[idx][0] = temp[1];
            ans[idx][1] = temp[2];
            ++idx;
        }
        return ans;
    }
}
