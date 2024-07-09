package InterviewBit;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaxDistance {

    public int maximumGap(final int[] A) {

        int n = A.length;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; ++i) {
            pq.offer(new int[]{A[i], i});
        }

        int max = 0;
        int minIndex = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            minIndex = Math.min(minIndex, temp[1]);
            max = Math.max(max, temp[1] - minIndex);
        }

        return max;

    }
}