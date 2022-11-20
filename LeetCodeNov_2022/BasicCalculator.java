import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {

        int n = s.length();
        int sum = 0;
        int sign = 1;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int val = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    val = (val * 10) + s.charAt(i) - '0';
                    ++i;
                }
                --i;
                val = val * sign;
                sum += val;
                sign = 1;
            } else if (ch == '-') {
                sign *= -1;
            } else if (ch == '(') {
                st.push(sum);
                st.push(sign);
                sum = 0;
                sign = 1;
            } else if (ch == ')') {
                sum *= st.pop();
                sum += st.pop();
            }
        }
        return sum;
    }
}
