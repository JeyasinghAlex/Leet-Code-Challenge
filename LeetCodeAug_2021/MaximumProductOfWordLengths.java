public class MaximumProductOfWordLengths {

    public int maxProduct(String[] words) {

        int[] bits = new int[words.length];
        for (int i = 0; i < words.length; ++i) {

            int mask = 0;
            for (char ch : words[i].toCharArray()) {
                int x = ch - 'a';
                mask |= 1 << x;
            }
            bits[i] = mask;
        }

        int max = 0;
        for (int i = 0; i < words.length; ++i) {
            for (int j = i + 1; j < words.length; ++j) {

                if ((bits[i] & bits[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    public int maxProduct_1(String[] words) {

        int max = 0;
        for (int i = 1; i < words.length; ++i) {
            boolean[] present = set(words[i]);
            for (int j = 0; j < i; ++j) {
                boolean flag = false;
                for (char ch : words[j].toCharArray()) {
                    if (present[ch - 'a']) {
                        flag = true;
                        break;
                    }
                }
                if (!flag)
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }

    private boolean[] set(String word) {

        boolean[] isPresent = new boolean[26];
        for (char ch : word.toCharArray()) {
            isPresent[ch - 'a'] = true;
        }
        return isPresent;
    }
}
