package StackAndQueue;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; ++i) {

            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }

            int val = st.isEmpty() ? 0 : st.peek() + 1;

            left[i] = val;

            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; --i) {

            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }

            int val = st.isEmpty() ? n - 1 : st.peek() - 1;

            right[i] = val;

            st.push(i);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; ++i) {
            int area = heights[i] * (right[i] - left[i] + 1);
            max = Math.max(max, area);
        }
        return max;
    }
}
