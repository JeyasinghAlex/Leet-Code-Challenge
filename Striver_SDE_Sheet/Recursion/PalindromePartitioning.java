package Recursion;

import java.util.*;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper(s, ans, list);
        return ans;
    }

    private void helper(String s, List<List<String>> ans, List<String> list) {

        if (s.length() == 0) {
            ans.add(new ArrayList<>(list));
            return ;
        }

        for (int i = 0; i < s.length(); ++i) {
            String substr = s.substring(0, i + 1);
            if (isPalindrome(substr)) {
                list.add(substr);
                helper(s.substring(i + 1), ans, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;

            ++i;
            --j;
        }
        return true;
    }
}
