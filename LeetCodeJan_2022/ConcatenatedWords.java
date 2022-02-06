import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords {

    private TrieNode root = new TrieNode();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        buildTrie(words);
        List<String> list = new ArrayList<>();
        for (String word : words) {
            search(word, list);
        }
        return list;
    }


    private void search(String s, List<String> list) {
        TrieNode node = root;
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (!node.containsKey((char) (ch - 'a'))) {
                return ;
            }
            if (node.isEnd()) {
                ++count;
            }
            if (count >= 2) {
                list.add(s);
                return ;
            }
            node = node.get((char)(ch - 'a'));
        }
    }


    private void buildTrie(String[] words) {

        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if(!node.containsKey((char) (ch - 'a'))) {
                    node.put((char) (ch - 'a'), new TrieNode());
                }
                node = node.get((char) (ch - 'a'));
            }
            node.setEnd();
        }
    }
}
