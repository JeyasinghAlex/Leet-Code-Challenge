package WeeklyContest_08_01_23;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaximalScoreAfterApplying_K_Operations {

    public long maxKelements(int[] nums, int k) {

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            pq.offer(num);
        }

        long ans = 0;

        while (k > 0) {

            int temp = pq.poll();
            ans += temp;
            pq.offer((int) Math.ceil(temp / 3.0));
            --k;
        }
        return ans;
    }
}
