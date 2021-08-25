import java.util.List;

public class ReplaceWords {

    private TrieNode root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        buildTrie(dictionary);
        String[] str = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : str) {
            TrieNode node = root;
            boolean flag = false;
            StringBuilder temp = new StringBuilder();
            for (char ch : word.toCharArray()) {
                temp.append(ch);
                node = node.get(ch);
                if (node == null) break;
                if (node.isEnd()) {
                    flag = true;
                    sb.append(temp + " ");
                    break;
                }
            }
            if (!flag) {
                sb.append(word + " ");
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private void buildTrie(List<String> dictionary) {

        for (String word : dictionary) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (!node.containsKey(ch)) {
                    node.put(ch);
                }
                node = node.get(ch);
            }
            node.setEnd();
        }
    }

    static class TrieNode {

        private TrieNode[] links;
        private boolean isEnd;

        public TrieNode() {
            this.links = new TrieNode[26];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch) {
            links[ch - 'a'] = new TrieNode();
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
