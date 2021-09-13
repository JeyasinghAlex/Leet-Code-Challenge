import java.util.PriorityQueue;
import java.util.Queue;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    public int longestSubarray(int[] nums, int limit) {

        Queue<Integer> minQu = new PriorityQueue<>();
        Queue<Integer> maxQu = new PriorityQueue<>((a, b) -> b - a);
        int start = 0;
        int end = 0;
        int res = 1;
        while (start <= end && end < nums.length) {
            minQu.offer(nums[end]);
            maxQu.offer(nums[end]);
            int min = minQu.peek();
            int max = maxQu.peek();
            if (max - min <= limit) {
                ++end;
                res = Math.max(res, end - start);
            } else {
                minQu.remove(nums[start]);
                maxQu.remove(nums[start]);
                ++start;
                ++end;
            }
        }
        return res;
    }
}
