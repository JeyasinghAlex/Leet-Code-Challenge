import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString_II {

    public String removeDuplicates(String s, int k) {

        Stack<int[]> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (st.isEmpty() || st.peek()[0] != ch) {
                st.push(new int[]{ch, 1});
            } else if ((char) st.peek()[0] == ch) {
                st.peek()[1] = st.peek()[1] + 1;
            }

            if (st.peek()[1] == k) {
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {

            int[] temp = st.pop();
            char ch = (char) temp[0];
            for (int i = 0; i < temp[1]; ++i) {
                sb.append(ch);
            }
        }
        return sb.reverse().toString();
    }
}