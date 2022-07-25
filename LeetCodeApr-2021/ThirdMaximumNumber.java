import java.util.Arrays;
import java.util.PriorityQueue;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {

        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int n : nums) {

            if (n > first) {
                third = second;
                second = first;
                first = n;
            } else if (n > second && n < first) {
                third = second;
                second = n;
            } else if (n > third && n < first && n < second) {
                third = n;
            }
        }
        return third == Long.MIN_VALUE ? (int) first : (int) third;
    }

    public static int thirdMax_1(int[] nums) {

        PriorityQueue<Integer> qu = new PriorityQueue<>();

        for (int num : nums) {
            if (!qu.contains(num)) {
                qu.offer(num);

                if (qu.size() > 3) {
                    qu.poll();
                }
            }
        }
        if (qu.size() == 2) {
            qu.poll();
        }
        return qu.peek();
    }

    public int thirdMax_2(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int count = 1, ans = 0, max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i > 0; --i) {
            if (nums[i] != nums[i - 1]) {
                if (++count == 3) {
                    return nums[i - 1];
                }
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
