public class MapSumPairs {

    /** Initialize your data structure here. */
    private TrieNode root;
    public MapSumPairs() {
        this.root = new TrieNode();
    }

    public void insert(String key, int val) {

        int temp = isEnd(key);
        TrieNode node = root;
        for (char ch : key.toCharArray()) {
            if (node.get(ch) == null) {
                node.put(ch);
            }
            node = node.get(ch);
            node.sum = node.sum - temp + val;
        }
        node.setEnd();
        node.endVal = val;
    }

    public int sum(String prefix) {

        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (node.get(ch) == null) {
                return 0;
            }
            node = node.get(ch);
        }
        return node.sum;
    }

    private int isEnd(String s) {

        TrieNode node = root;
        for (char ch : s.toCharArray()) {
            if (node.get(ch) == null) {
                return 0;
            }
            node = node.get(ch);
        }
        return node.isEnd() ? node.endVal : 0;
    }

    static class TrieNode {

        private TrieNode[] links;
        private boolean isEnd;
        int sum;
        int endVal;

        public TrieNode() {
            this.links = new TrieNode[26];
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch) {
            links[ch - 'a'] = new TrieNode();
        }

        public boolean isEnd() {
            return isEnd;
        }

        public int getSum() {
            return sum;
        }

        public boolean setEnd() {
            return isEnd = true;
        }

    }
/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
}
