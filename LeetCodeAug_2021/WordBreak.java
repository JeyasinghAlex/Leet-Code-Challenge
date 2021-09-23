import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {

    static class TrieNode {

        private TrieNode[] links;
        private boolean isEnd;

        public TrieNode() {
            this.links = new TrieNode[26];
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public TrieNode[] getNodes() {
            return this.links;
        }

        public void put(char ch) {
            links[ch - 'a'] = new TrieNode();
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }

    private TrieNode root = new TrieNode();
    public boolean wordBreak(String s, List<String> wordDict) {
        buildTrie(wordDict);
        boolean[] visited = new boolean[s.length()];
        return searchFrom(s, 0, root, visited);
    }

    private boolean searchFrom(String s, int start, TrieNode root, boolean[] searched) {
        if (start == s.length()) {
            return true;
        }

        TrieNode node = root;

        for (int pos = start; pos < s.length(); pos++) {
            node = node.get(s.charAt(pos));

            if (node == null) break;

            if (node.isEnd() && !searched[pos]) {
                searched[pos] = true;
                if (searchFrom(s, pos + 1, root, searched)) {
                    return true;
                }
            }
        }

        return false;
    }

    private void buildTrie(List<String> wordDict) {

        for (String s : wordDict) {
            TrieNode node = root;
            for (char ch : s.toCharArray()) {

                if (!node.containsKey(ch)) {
                    node.put(ch);
                }
                node = node.get(ch);
            }
            node.setEnd();
        }
    }

    public boolean dp(String s, List<String> wordDict) {

        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int i = 0; i < n; ++i) {
            if (wordDict.contains(s.substring(i, i + 1))) {
                dp[i + 1][i + 1] = true;
            } else {
                dp[i + 1][i + 1] = false;
            }
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= n - i; ++j) {

                int k = j + i;
                if (wordDict.contains(s.substring(j - 1, k))) {
                    dp[j][k] = true;
                } else {
                    for (int l = j; l < k; ++l) {
                        dp[j][k] = dp[j][l] && dp[l + 1][k];

                        if (dp[j][k]) {
                            break;
                        }
                    }
                }
            }
        }
        return dp[1][n];
    }

    public boolean memoization(int index, String s, List<String> dict, Map<String, Boolean> map) {

        if (dict.contains(s) || index == s.length()) {
            return true;
        }

        if (map.get(s) != null) {
            return map.get(s);
        }

        for (int i = index; i < s.length(); ++i) {

            String substr = s.substring(index, i + 1);
            if (dict.contains(substr) && memoization(0, s.substring(i + 1), dict, map)) {
                map.put(substr, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }

    public boolean wordBreak_1(String s, List<String> wordDict) {
        // put all words into a hashset
        Set<String> set = new HashSet<>(wordDict);
        return wb(s, set);
    }

    private boolean wb(String s, Set<String> set) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        for (int i = 1; i <= len; ++i) {
            if (set.contains(s.substring(0, i)) && wb(s.substring(i), set)) {
                return true;
            }
        }
        return false;
    }
}
