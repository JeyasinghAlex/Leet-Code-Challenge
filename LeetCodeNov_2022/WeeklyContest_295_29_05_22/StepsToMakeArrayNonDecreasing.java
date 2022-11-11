package WeeklyContest_295_29_05_22;

import java.util.Stack;

public class StepsToMakeArrayNonDecreasing {

    public int totalSteps(int[] nums) {

        int n = nums.length;
        Stack<int[]> st = new Stack<>();

        for (int i = n - 1; i >= 0; --i) {

            int step = 0;
            while (!st.isEmpty()) {

                int[] top = st.peek();
                if (top[0] >= nums[i]) {
                    break;
                }
                step = Math.max(step + 1, top[1]);
                st.pop();
            }
            st.push(new int[]{nums[i], step});
        }

        int ans = 0;
        while (!st.isEmpty()) {
            ans = Math.max(ans, st.pop()[1]);
        }
        return ans;
    }
}
