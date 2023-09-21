package Trie;

public class ImplementTrie_II {

    private TrieNode_1 root;
    public ImplementTrie_II() {
        this.root = new TrieNode_1();
        // Write your code here.
    }

    public void insert(String word) {
        // Write your code here.
        TrieNode_1 node = root;
        for (char ch : word.toCharArray()) {
            if (!node.contains(ch)) {
                node.put(ch);
            }
            node = node.get(ch);
            node.increaseCount();
        }
        // node.increaseEnd();
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

    public int countWordsEqualTo(String word) {
        // Write your code here.

        TrieNode_1 node = prefixSearch(word);
        if (node == null)
            return 0;

        return node.isEnd() ? node.getCount() : 0;
    }

    public int countWordsStartingWith(String word) {
        TrieNode_1 node = prefixSearch(word);
        if (node == null)
            return 0;

        return node.getCount();
    }

    public void erase(String word) {
        // Write your code here.
        TrieNode_1 node = root;
        for (char ch : word.toCharArray()) {
            if (node.contains(ch)) {
                node = node.get(ch);
                node.decreaseCount();
                if (node.getCount() == 0) {
                    node.erase(ch);
                }
            }
        }
    }
}

class Node {

    private TrieNode_1[] link;
    private int count;
    private boolean isEnd;

    public Node() {
        this.link = new TrieNode_1[26];
    }

    public boolean contains(char ch) {
        return link[ch - 'a'] != null;
    }

    public void erase(char ch) {
        link[ch - 'a'] = null;
    }

    public void put(char ch) {
        link[ch - 'a'] = new TrieNode_1();
    }

    public void increaseCount() {
        this.count++;
    }

    public void decreaseCount() {
        this.count--;
    }

    public TrieNode_1 get(char ch) {
        return link[ch - 'a'];
    }

    public void setEnd() {
        isEnd = true;
    }

    public int getCount() {
        return count;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
