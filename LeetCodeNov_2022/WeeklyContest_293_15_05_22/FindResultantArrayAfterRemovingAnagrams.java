package WeeklyContest_293_15_05_22;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindResultantArrayAfterRemovingAnagrams {

    public List<String> removeAnagrams(String[] words) {

        int n = words.length;
        Stack<String> st = new Stack<>();
        for (int i = n - 1; i >= 0; --i) {

            String word = words[i];
            if (!st.isEmpty()) {
                String top = st.peek();
                if (isAnagrams(top, word)) {
                    st.pop();
                }
            }
            st.push(word);
        }

        List<String> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
        return ans;
    }

    private boolean isAnagrams(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (int i = 0; i < a.length(); ++i) {
            freq[a.charAt(i) - 'a']++;
            freq[b.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; ++i) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
