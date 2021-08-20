import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {

        List<String> ans = new ArrayList<>();
        dfs(ans, s.toCharArray(), 0);
        return ans;
    }


    private void dfs(List<String> ans, char[] c, int i) {

        if (i == c.length) {
            ans.add(new String(c));
            return ;
        }

        if (Character.isLetter(c[i])) {
            c[i] = Character.toLowerCase(c[i]);
            dfs(ans, c, i + 1);
            c[i] = Character.toUpperCase(c[i]);
            dfs(ans, c, i + 1);
        } else {
            dfs(ans, c, i + 1);
        }
    }

    public List<String> letterCasePermutation_1(String s) {

        int n = s.length();
        int len = 1 << n;
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < len; ++i) {
            StringBuilder sb = new StringBuilder(s);
            for (int j = 0, temp = i; temp != 0; temp >>>= 1, ++j) {

                if (sb.charAt(j) >= 'a' && sb.charAt(j) <= 'z' && (temp & 1) == 1) {
                    char ch = (char) (sb.charAt(j) - 32);
                    sb.setCharAt(j, ch);
                }
                else if (sb.charAt(j) >= 'A' && sb.charAt(j) <= 'Z' && (temp & 1) == 1) {
                    char ch = (char) (sb.charAt(j) + 32);
                    sb.setCharAt(j, ch);
                }
            }
            ans.add(sb.toString());
        }
        return new ArrayList<>(ans);
    }
}
