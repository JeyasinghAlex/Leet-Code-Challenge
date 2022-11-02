package BiWeeklyContest_82_07_09_22;

import java.util.Stack;

public class SubArrayWithElementsGreaterThanVaryingThreshold {


    public int validSubarraySize(int[] nums, int threshold) {

        //Similer problem: 84. Largest Rectangle in Histogram
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            int val = st.isEmpty() ? 0 : st.peek() + 1;
            left[i] = val;
            st.push(i);
        }

        st.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            int val = st.isEmpty() ? n - 1 : st.peek() - 1;
            right[i] = val;
            st.push(i);
        }

        for (int i = 0; i < n; ++i) {
            int subArrayLen = right[i] - left[i] + 1;

            if (nums[i] > threshold / (double) subArrayLen) {
                return subArrayLen;
            }
        }
        return -1;
    }
}
