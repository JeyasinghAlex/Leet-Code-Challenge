import java.util.*;

public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {

        Queue<String> qu = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<String> list = new ArrayList<>();

        qu.offer(s);
        visited.add(s);

        boolean found = false;
        while (!qu.isEmpty()) {

            s = qu.poll();

            boolean isValid = isValid(s);
            if (isValid) {
                list.add(s);
                found = true;
            }

            if (found) {
                continue;
            }

            for (int i = 0; i < s.length(); ++i) {

                if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                    continue;
                }

                String temp = s.substring(0, i) + s.substring(i + 1);

                if (!visited.contains(temp)) {
                    qu.offer(temp);
                    visited.add(temp);
                }
            }
        }

        return list;
    }

    private boolean isValid(String s) {

        int count = 0;
        for (int i = 0; i < s.length(); ++i) {

            char ch = s.charAt(i);
            if (ch == '(') {
                ++count;
            } else if (ch == ')'){
                --count;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
