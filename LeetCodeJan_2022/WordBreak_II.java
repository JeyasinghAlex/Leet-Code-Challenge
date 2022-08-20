import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_II {

    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> ans = new ArrayList<>();
        backtrack(s, "", wordDict, ans);
        return ans;
    }


    private void backtrack(String s, String str, List<String> wordDict, List<String> ans) {

        if (s.length() == 0) {
            str = str.substring(0, str.length() - 1);
            ans.add(str);
            return ;
        }

        for (int i = 0; i <= s.length(); ++i) {

            String substr = s.substring(0, i);

            if (wordDict.contains(substr)) {
                backtrack(s.substring(i), str + substr + ' ', wordDict, ans);
            }
        }
    }

    public List<String> wordBreak_1(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        List<String> list = new ArrayList<>();
        wordBreak(s, "", set, list, s.length(), 0);
        return list;
    }

    private void wordBreak(String s, String str, Set<String> set, List<String> list, int n, int count) {

        if(s.length() == 0 && str.length() - count == n) {
            list.add(str.substring(0, str.length() - 1));
            return;
        }

        for (int i = 1; i <= s.length(); ++i) {
            if (set.contains(s.substring(0, i))) {
                for (int j = i; j <= s.length(); ++j) {
                    wordBreak(s.substring(j), str + s.substring(0, i) + " ", set, list, n, count + 1);
                }
            }
        }
    }
}
