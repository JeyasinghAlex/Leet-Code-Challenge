package Trie;

public class ImplementTrie {

    private TrieNode_1 root;
    public ImplementTrie() {
        this.root = new TrieNode_1();
    }

    public void insert(String word) {
        TrieNode_1 node = root;
        for (char ch : word.toCharArray()) {
            if (!node.contains(ch))
                node.put(ch);
            node = node.get(ch);
        }
        node.setEnd();
    }

    private TrieNode_1 prefixSearch(String word) {
        TrieNode_1 node = root;
        for (char ch : word.toCharArray()) {
            if (node.contains(ch))
                node = node.get(ch);
            else
                return null;
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode_1 node = prefixSearch(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        return prefixSearch(prefix) != null;
    }
}


class TrieNode {

    private TrieNode_1[] link;
    private boolean isEnd;

    public TrieNode() {
        this.link = new TrieNode_1[26];
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
        this.isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
