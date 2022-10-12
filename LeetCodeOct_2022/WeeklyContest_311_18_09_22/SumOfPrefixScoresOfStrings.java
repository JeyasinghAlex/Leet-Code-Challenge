package WeeklyContest_311_18_09_22;

public class SumOfPrefixScoresOfStrings {

    public int[] sumPrefixScores(String[] words) {

        int n = words.length;

        TrieNode root = new TrieNode();
        constructTrie(words, root);

        int[] ans = new int[n];

        for (int i = 0; i < n; ++i) {
            ans[i] = getPrefixScore(words[i], root);
        }
        return ans;
    }

    private int getPrefixScore(String word, TrieNode node) {

        int score = 0;

        for (char ch : word.toCharArray()) {
            score += node.get(ch).getValue();
            node = node.get(ch);
        }
        return score;
    }

    private void constructTrie(String[] words, TrieNode root) {

        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {

                if (!node.contains(ch)) {
                    node.put(ch);
                }
                node = node.get(ch);
                node.setValue();
            }
        }
    }
}

class TrieNode {

    private TrieNode[] links;
    private int value;

    public TrieNode() {
        this.links = new TrieNode[26];
    }

    public int getValue() {
        return this.value;
    }

    public void setValue() {
        this.value += 1;
    }

    public TrieNode get(char ch) {
        return this.links[ch - 'a'];
    }

    public boolean contains(char ch) {
        return this.links[ch - 'a'] != null;
    }

    public void put(char ch) {
        this.links[ch - 'a'] = new TrieNode();
    }
}