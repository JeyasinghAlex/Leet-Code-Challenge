import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {

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
