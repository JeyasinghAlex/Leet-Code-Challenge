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

    public static int largestRectangleArea_1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < height.length; i++) {
            int p = i - 1;

            while (p >= 0 && height[p] >= height[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }

    public int largestRectangleArea_2(int[] height) {

        Stack<Integer> st = new Stack<>();
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; ++i) {

            if (st.isEmpty()) {
                left[i] = i;
            } else {
                while (!st.isEmpty() && height[i] <= height[st.peek()]) {
                    st.pop();
                }
                left[i] = st.isEmpty() ? 0 : st.peek() + 1;
            }
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; --i) {
            if (st.isEmpty()) {
                right[i] = i;
            } else {
                while (!st.isEmpty() && height[i] <= height[st.peek()]) {
                    st.pop();
                }
                right[i] = st.isEmpty() ? n - 1 : st.peek() - 1;
            }
            st.push(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            int ans = height[i] * (right[i] - left[i] + 1);
            max = Math.max(max, ans);
        }
        return max;
    }
}
