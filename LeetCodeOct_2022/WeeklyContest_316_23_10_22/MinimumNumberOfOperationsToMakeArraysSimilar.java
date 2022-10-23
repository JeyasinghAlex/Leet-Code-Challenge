package WeeklyContest_316_23_10_22;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumNumberOfOperationsToMakeArraysSimilar {

    public long makeSimilar(int[] nums, int[] target) {

        int n = nums.length;
        Queue<Integer> numsOdd = new PriorityQueue<>();
        Queue<Integer> numsEven = new PriorityQueue<>();
        Queue<Integer> targetOdd = new PriorityQueue<>();
        Queue<Integer> targetEven = new PriorityQueue<>();

        for (int i = 0; i < n; ++i) {
            if (nums[i] % 2 == 0)
                numsEven.offer(nums[i]);
            else
                numsOdd.offer(nums[i]);

            if (target[i] % 2 == 0)
                targetEven.offer(target[i]);
            else
                targetOdd.offer(target[i]);
        }

        long ans = 0;
        while (!numsEven.isEmpty()) {
            int x = numsEven.poll();
            int y = targetEven.poll();
            if (x > y)
                ans += (x - y) / 2;
        }

        while (!numsOdd.isEmpty()) {
            int x = numsOdd.poll();
            int y = targetOdd.poll();
            if (x > y)
                ans += (x - y) / 2;
        }
        return ans;
    }
}
