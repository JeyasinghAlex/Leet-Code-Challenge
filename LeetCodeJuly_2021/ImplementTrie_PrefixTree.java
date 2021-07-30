public class ImplementTrie_PrefixTree {


    static class Node {

        public Node[] nodes = new Node[26];
        public boolean isEnd;

        public Node[] getNodes() {
            return this.nodes;
        }

        public void setNodes(Node[] nodes) {
            this.nodes = nodes;
        }

        public void setEnd(boolean end) {
            this.isEnd = end;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }

    /** Initialize your data structure here. */
    private Node root;
    public ImplementTrie_PrefixTree() {
        this.root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node currentNode = root;
        for (char ch : word.toCharArray()) {
            if (currentNode.nodes[ch - 'a'] == null) {
                currentNode.nodes[ch - 'a'] = new Node();
            }
            currentNode = currentNode.nodes[ch - 'a'];
        }
        currentNode.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node currentNode = root;
        for (char ch : word.toCharArray()) {
            if (currentNode.nodes[ch - 'a'] == null) {
                return false;
            }
            currentNode = currentNode.nodes[ch - 'a'];
        }
        return currentNode.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        Node currentNode = root;
        for (char ch : prefix.toCharArray()) {
            if (currentNode.nodes[ch - 'a'] == null) {
                return false;
            }
            currentNode = currentNode.nodes[ch - 'a'];
        }
        return true;
    }
}

