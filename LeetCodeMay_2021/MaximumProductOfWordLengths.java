package LeetCodeMay_2021;

public class MaximumProductOfWordLengths {

    public int maxProduct(String[] words) {

        int count = 0;
        int max = 0;
        for (int i = 0; i < words.length; ++i) {
            String s1 = words[i];
            for (int j = i + 1; j < words.length; ++j) {
                String s2 = words[j];
                count = 0;
                for (int k = 0; k < s2.length(); ++k) {
                    if (s1.indexOf(s2.charAt(k)) == -1) {
                        ++count;
                    } else {
                        count = 0;
                        break;
                    }
                }
                max = Math.max(max, s1.length() * count);
            }
        }
        return max;
    }
}
