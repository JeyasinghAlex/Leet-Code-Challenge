public class DesignAddAndSearchWordsDataStructure {


    private TrieNode root;
    /** Initialize your data structure here. */
    public DesignAddAndSearchWordsDataStructure() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    private boolean helper(int idx, String word, TrieNode node) {
        if (idx == word.length()) {
            if (node.isEnd()) {
                return true;
            }
            return false;
        }


        char ch = word.charAt(idx);
        if (ch == '.') {

            for (int j = 0; j < 26; ++j) {

                if (node.links[j] != null) {
                    if (helper(idx + 1, word, node.links[j])) {
                        return true;
                    }
                }
            }
        } else {
            if (node.links[ch - 'a'] != null) {
                return helper(idx + 1, word, node.links[ch - 'a']);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean search(String word) {
        TrieNode node = root;
        return helper(0, word, node);
    }



    static class TrieNode {

        TrieNode[] links;
        private boolean isEnd;

        public TrieNode() {
            this.links = new TrieNode[26];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }

}