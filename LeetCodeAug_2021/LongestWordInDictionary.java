import java.util.LinkedList;
import java.util.Queue;

public class LongestWordInDictionary {

    private TrieNode root;
    private int max;
    public String longestWord(String[] words) {

        root = new TrieNode();
        buildTrie(words);
        return longestWord();
    }

    private String longestWord() {
        String result = "";
        Queue<TrieNode> qu = new LinkedList<>();
        qu.offer(root);
        while (!qu.isEmpty()) {
            int len = qu.size();
            while (len-- > 0) {
                TrieNode node = qu.poll();
                for (int i = 25; i >= 0; --i) {
                    if (node.links[i] != null && node.links[i].isEnd()) {
                        result = node.links[i].getWord();
                        qu.offer(node.links[i]);
                    }
                }
            }
        }
        return result;
    }


    private void buildTrie(String[] words) {

        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {

                if (!node.containsKey(ch)) {
                    node.put(ch);
                }
                node = node.get(ch);
            }
            node.setEnd();
            node.setWord(word);
        }
    }

    class TrieNode {

        TrieNode[] links;
        private boolean isEnd;
        private String word;

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
            return isEnd;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public String getWord() {
            return this.word;
        }
    }
}
