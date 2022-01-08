import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int[] height = new int[col];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                height[j] = (matrix[i][j] == '0') ? 0 : (height[j] + (matrix[i][j] - '0'));
            }
            int ans = largestRectangleArea(height);
            max = Math.max(max, ans);
        }
        return max;
    }

    public int largestRectangleArea(int[] height) {

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