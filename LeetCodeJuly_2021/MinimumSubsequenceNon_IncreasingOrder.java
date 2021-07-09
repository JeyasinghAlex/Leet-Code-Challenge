import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSubsequenceNon_IncreasingOrder {

    public List<Integer> minSubsequence(int[] nums) {

        Arrays.sort(nums);
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        int elementSum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            elementSum += nums[i];
            list.add(nums[i]);
            if (elementSum > sum - elementSum) {
                return list;
            }
        }

        return new ArrayList<>();
    }

    public List<Integer> minSubsequence_1(int[] nums) {

        PriorityQueue<Integer> qu = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int n : nums) {
            qu.offer(n);
            sum += n;
        }

        int elementSum = 0;
        List<Integer> list = new ArrayList<>();
        while (!qu.isEmpty()) {

            int temp = qu.poll();
            elementSum += temp;
            list.add(temp);
            if (elementSum > sum - elementSum) {
                return list;
            }
        }

        return new ArrayList<>();
    }
}
