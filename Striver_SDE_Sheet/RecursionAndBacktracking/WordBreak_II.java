package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class WordBreak_II {

    public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
        // Write your code here.
        int n = s.length();
        ArrayList<String> ans = new ArrayList<>();
        backtrack("", s, dictionary, ans);
        return ans;
    }

    private static void backtrack(String str, String s, List<String> dictionary, List<String> ans) {


        if (s.isEmpty()) {
            ans.add(str.substring(0, str.length() - 1));
            return ;
        }

        String substr = "";
        for (int i = 0; i < s.length(); ++i) {
            substr += s.charAt(i);
            if (dictionary.contains(substr)) {
                String temp = str + substr + " ";
                backtrack(temp, s.substring(i + 1), dictionary, ans);
            }
        }
    }
}
