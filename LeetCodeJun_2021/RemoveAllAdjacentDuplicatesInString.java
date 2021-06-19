import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String s) {

        StringBuilder sb = new StringBuilder();
        int len = 0;

        for (char ch : s.toCharArray()) {
            len = sb.length();
            if (len > 0 && sb.charAt(len - 1) == ch) {
                sb.deleteCharAt(len - 1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public String removeDuplicates_1(String s) {

        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (st.isEmpty() || st.peek() != ch) {
                st.push(ch);
            } else {
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
