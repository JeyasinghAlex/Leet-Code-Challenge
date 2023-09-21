package Trie;

public class CountDistinctSubStrings {

    public static int countDistinctSubstrings(String s) {
        //	  Write your code here.
        TrieNode_2 node = new TrieNode_2();
        int n = s.length();
        int result = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                result += constructTrie(s.substring(j, n), node);
            }
        }
        return result + 1;
    }

    private static int constructTrie(String word, TrieNode_2 node) {

        int count = 0;
        for (char ch : word.toCharArray()) {
            if (!node.contains(ch)) {
                node.put(ch);
                ++count;
            }
            node = node.get(ch);
        }
        return count;
    }
}

class TrieNode_2 {

    private TrieNode_2[] link;
    private boolean isEnd;

    public TrieNode_2() {
        this.link = new TrieNode_2[26];
    }

    public boolean contains(char ch) {
        return link[ch - 'a'] != null;
    }

    public void put(char ch) {
        link[ch - 'a'] = new TrieNode_2();
    }

    public TrieNode_2 get(char ch) {
        return link[ch - 'a'];
    }
}
