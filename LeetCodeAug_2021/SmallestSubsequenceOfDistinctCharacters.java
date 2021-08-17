import java.util.Stack;

public class SmallestSubsequenceOfDistinctCharacters {

    public String smallestSubsequence(String s) {

        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for (char ch : s.toCharArray()) {

            count[ch - 'a']--;
            if (visited[ch - 'a']) {
                continue;
            }

            while (!st.isEmpty() && st.peek() > ch && count[st.peek() - 'a'] > 0) {
                visited[st.peek() - 'a'] = false;
                st.pop();
            }
            st.push(ch);
            visited[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
