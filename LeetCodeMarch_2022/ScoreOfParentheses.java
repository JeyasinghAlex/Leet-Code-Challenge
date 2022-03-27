import java.util.Stack;

public class ScoreOfParentheses {

    public int scoreOfParentheses(String s) {

        Stack<Integer> st = new Stack<>();
        int count = 0;
        for (char ch : s.toCharArray()) {

            int val = 0;
            if (ch == '(') {
                st.push(0);
            } else {
                while (st.peek() != 0) {
                    val += st.pop();
                }
                val = Math.max(2 * val, 1);
                st.pop();
                st.push(val);
            }
        }
        while (!st.isEmpty()) {
            count += st.pop();
        }
        return count;
    }

    public int scoreOfParentheses_1(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i-1) == '(')
                    ans += 1 << bal;
            }
        }
        return ans;
    }
}
