public class UniqueSubstringsInWraparoundString {

    public int findSubstringInWraproundString(String p) {

        int[] count = new int[26];
        int currLength = 1;
        for (int i = 0; i < p.length(); ++i) {

            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)) {
                ++currLength;
            } else {
                currLength = 1;
            }

            int idx = p.charAt(i) - 'a';
            count[idx] = Math.max(count[idx], currLength);
        }

        int sum = 0;
        for (int i = 0; i < 26; ++i) {
            sum += count[i];
        }
        return sum;
    }
}
