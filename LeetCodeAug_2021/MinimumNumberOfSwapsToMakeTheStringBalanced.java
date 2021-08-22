import java.util.Stack;

public class MinimumNumberOfSwapsToMakeTheStringBalanced {

    public int minSwaps(String s) {

        Stack<Character> st = new Stack<>();
        int missMatch = 0;
        for (char ch : s.toCharArray()) {

            if (ch == '[') {
                st.push(ch);
            } else {
                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    ++missMatch;
                }
            }
        }
        return (missMatch + 1) / 2;
    }
}
