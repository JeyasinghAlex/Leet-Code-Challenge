import java.util.Stack;

public class BaseballGame {

    public int calPoints(String[] ops) {

        Stack<Integer> st = new Stack<>();

        for (String s : ops) {

            if (s.equals("D")) {
                int top = st.peek();
                st.push(top * 2);
            } else if (s.equals("C")) {
                st.pop();
            } else if (s.equals("+")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b);
                st.push(a);
                st.push(a + b);
            } else {
                int val = Integer.parseInt(s);
                st.push(val);
            }
        }

        int ans = 0;
        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }
}
