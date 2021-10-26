import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>();
        boolean isPresent = false;
        for (String s : wordList) {
            if (s.equals(endWord)) {
                isPresent = true;
            }
            set.add(s);
        }

        if (!isPresent) {
            return 0;
        }
        return bfs(set, beginWord, endWord);
    }

    private int bfs(Set<String> set, String biginWord, String endWord) {

        Queue<String> qu = new LinkedList<>();
        qu.offer(biginWord);
        set.remove(biginWord);

        int shortest = 1;
        while (!qu.isEmpty()) {
            int len = qu.size();
            while (len-- > 0) {
                String temp = qu.poll();
                if (endWord.equals(temp)) {
                    return shortest;
                }
                for (int i = 0; i < temp.length(); ++i) {
                    char[] chars = temp.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        chars[i] = ch;

                        String str = String.valueOf(chars);

                        if (set.contains(str)) {
                            qu.offer(str);
                            set.remove(str);
                        }
                    }
                }
            }
            shortest++;
        }
        return 0;
    }
}
