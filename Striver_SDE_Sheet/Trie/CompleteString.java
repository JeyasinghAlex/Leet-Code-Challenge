package Trie;

public class CompleteString {

    public static String completeString(int n, String[] a) {
        // Write your code here.
        TrieNode_1 root = new TrieNode_1();
        for (String word : a) {
            constructTrie(word, root);
        }

        String result = "";
        for (String word : a) {
            if (search(word, root)) {
                if (result.isEmpty()) {
                    result = word;
                    continue;
                }

                if (word.length() > result.length()) {
                    result = word;
                    continue;
                }

                int temp = result.compareTo(word);

                if (result.length() == word.length() && temp > 0) {
                    result = word;
                }
            }
        }
        return result.isEmpty() ? "None" : result;
    }

    public static boolean search(String word, TrieNode_1 node) {

        for (char ch : word.toCharArray()) {
            if (node.contains(ch)) {
                node = node.get(ch);
                if (!node.isEnd()) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void constructTrie(String word, TrieNode_1 node) {

        for (char ch : word.toCharArray()) {
            if (!node.contains(ch)) {
                node.put(ch);
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
}

class TrieNode_1 {

    private TrieNode_1[] link;
    private boolean isEnd;

    public TrieNode_1() {
        link = new TrieNode_1[26];
    }

    public boolean contains(char ch) {
        return link[ch - 'a'] != null;
    }

    public void put(char ch) {
        link[ch - 'a'] = new TrieNode_1();
    }

    public TrieNode_1 get(char ch) {
        return link[ch - 'a'];
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
