import java.util.Stack;

public class MakeTheStringGreat {

    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()) {

            int l = sb.length();
            if (l != 0 && (sb.charAt(l - 1) == (char) (ch - 32) || sb.charAt(l - 1) == (char) (ch + 32))) {
                sb.deleteCharAt(l - 1);
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public String makeGood_1(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()) {
            if (!st.isEmpty() && (st.peek() == (char) (ch - 32) || st.peek() == (char) (ch + 32))) {
                st.pop();
            }else {
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
