import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(ans, list, 0, s);
        return ans;
    }

    private void dfs(List<List<String>> ans, List<String> list, int start, String s) {

        if (start == s.length()) {
            ans.add(new ArrayList<>(list));
            return ;
        }

        for (int i = start; i < s.length(); ++i) {

            boolean isPalindrome = isPalindrome(s, start, i);
            if (isPalindrome) {
                String subString = substring(s, start, i);
                list.add(subString);
                dfs(ans, list, i + 1, s);
                list.remove(list.size() - 1);
            }
        }
    }

    private String substring(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; ++i) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private boolean isPalindrome(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            ++i; --j;
        }
        return true;
    }
}
