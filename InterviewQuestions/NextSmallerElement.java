package InterviewQuestions;

import java.util.Stack;

public class NextSmallerElement {

    /**
     * salesforce
     */
    public int[] NextSmallerElement(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; ++i) {

            while (!st.isEmpty() && nums[i] <= st.peek()) {
                st.pop();
            }

            int val = st.isEmpty() ? -1 : st.peek();

            ans[i] = val;

            st.push(nums[i]);
        }
        return ans;
    }
}
