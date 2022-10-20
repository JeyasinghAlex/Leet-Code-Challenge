package WeeklyContest_308_28_8_22;

import java.util.Stack;

public class RemovingStarsFromString {

    public String removeStars(String s) {

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '*' && !st.isEmpty()) {
                st.pop();
            } else {
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
