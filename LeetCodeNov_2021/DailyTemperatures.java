import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; --i) {

            while (!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]) {
                st.pop();
            }

            int val = st.isEmpty() ? 0 : st.peek() - i;
            st.push(i);
            ans[i] = val;
        }
        return ans;
    }
    public int[] dailyTemperatures_1(int[] temperatures) {

        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; ++i) {

            int curr = temperatures[i];
            while (!st.isEmpty() && temperatures[st.peek()] < curr) {
                int prev = st.pop();
                ans[prev] = i - prev;
            }
            st.push(i);
        }
        return ans;
    }
}
