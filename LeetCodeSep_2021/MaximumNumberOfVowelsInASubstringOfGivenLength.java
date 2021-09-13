public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    private boolean[] vowel = new boolean[26];

    public int maxVowels(String s, int k) {
        vowel['a' - 'a'] = true;
        vowel['e' - 'a'] = true;
        vowel['i' - 'a'] = true;
        vowel['o' - 'a'] = true;
        vowel['u' - 'a'] = true;
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < k; ++i) {
            char ch = s.charAt(i);
            if (vowel[ch - 'a']) {
                ++count;
            }
        }
        max = Math.max(max, count);

        for (int i = 0; i < s.length() - k; ++i) {

            char ch1 = s.charAt(i);
            if (vowel[ch1 - 'a']) {
                --count;
            }
            char ch2 = s.charAt(i + k);
            if (vowel[ch2 - 'a']) {
                ++count;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
