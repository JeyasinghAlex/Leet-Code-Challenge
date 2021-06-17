import java.util.Arrays;
import java.util.PriorityQueue;

public class ThirdMaximumNumber {

    public static void main(String[] args) {
        System.out.println(thirdMax_1(new int[]{-2147483648,1,1}));
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
