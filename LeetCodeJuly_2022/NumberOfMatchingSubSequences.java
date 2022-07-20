public class NumberOfMatchingSubSequences {

    public int numMatchingSubseq(String s, String[] words) {

        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : map.keySet()) {
            if (isSubSequences(s, word)) {
                count += map.get(word);
            }
        }
        return count;
    }


    private boolean isSubSequences(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        if (n > m) {
            return false;
        }

        int i = 0;
        int j = 0;

        while (i < m && j < n) {

            if (s1.charAt(i) == s2.charAt(j)) {
                ++j;
            }
            ++i;
        }

        return n == j;
    }
}
