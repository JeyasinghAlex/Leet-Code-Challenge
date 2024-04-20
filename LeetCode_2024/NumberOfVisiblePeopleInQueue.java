package LeetCode_2024;

import java.util.Stack;

public class NumberOfVisiblePeopleInQueue {

    public int[] canSeePersonsCount(int[] heights) {

        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; --i) {

            int popCount = 0;
            while (!st.isEmpty() && heights[i] > heights[st.peek()]) {
                st.pop();
                ++popCount;
            }

            int visible = popCount + (st.isEmpty() ? 0 : 1);
            st.push(i);

            ans[i] = visible;
        }

        return ans;
    }
}
