import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class MaximizeSumOfArrayAfterKNegations {

    public int largestSumAfterKNegations(int[] nums, int k) {

        PriorityQueue<Integer> qu = new PriorityQueue<>();
        for (int n : nums) {
            qu.offer(n);
        }

        while (k-- > 0) {
            qu.offer(-qu.poll());
        }

        int sum = 0;
        while (!qu.isEmpty()) {
            sum += qu.poll();
        }

        return sum;
    }

    public int largestSumAfterKNegations_1(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; k > 0 && i < nums.length; ++i) {

            if (nums[i] < 0) {
                nums[i] = Math.abs(nums[i]);
                --k;
            }
            min = Math.min(min, nums[i]);
        }

        int temp = min;
        if (k > 0) {
            min = (k & 1) == 1 ? -min : min;
        }
        return IntStream.of(nums).sum() - temp + min;
    }
}
