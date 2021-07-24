import java.util.PriorityQueue;
import java.util.Queue;

public class JumpGame_VI {

    public int maxResult(int[] nums, int k) {

        Queue<int[]> qu = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        qu.offer(new int[]{nums[0], 0});
        int max =   nums[0];
        for (int i = 1; i < nums.length; ++i) {

            while (qu.peek()[1] + k < i) {
                qu.poll();
            }

            int[] curr = qu.peek();
            max = curr[0] + nums[i];
            qu.offer(new int[]{max, i});
        }
        return max;
    }
}
