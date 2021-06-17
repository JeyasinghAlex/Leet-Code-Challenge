import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();
        String s = "";
        backtrack(list, s, n, 0, 0);
        return list;

    }

    private void backtrack(List<String> list, String s, int n, int open, int close) {

        if (s.length() == n * 2) {
            list.add(s);
            return;
        }

        if (open < n) {
            backtrack(list, s + '(', n, open + 1, close);
        }
        if (close < open) {
            backtrack(list, s + ')', n, open, close + 1);
        }
    }

}
