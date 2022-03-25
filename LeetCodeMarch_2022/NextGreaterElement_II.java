import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement_II {

    public int[] nextGreaterElements(int[] A) {
        int n = A.length, res[] = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i % n])
                res[stack.pop()] = A[i % n];
            stack.push(i % n);
        }
        return res;
    }

    public int[] nextGreaterElements_1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int n = nums.length;
        int[] result = new int[n];
        int[] temp = new int[n * 2];

        for (int i = 0; i < n * 2; i++) {
            temp[i] = nums[i % n];
        }

        for (int i = 0; i < n; i++) {
            result[i] = -1;
            if (nums[i] == max) continue;

            for (int j = i + 1; j < n * 2; j++) {
                if (temp[j] > nums[i]) {
                    result[i] = temp[j];
                    break;
                }
            }
        }
        return result;
    }
}
