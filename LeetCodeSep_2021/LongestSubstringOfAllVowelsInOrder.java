public class LongestSubstringOfAllVowelsInOrder {

    public int longestBeautifulSubstring(String word) {

        int n = word.length();
        int cnt = 1;
        int len = 1;
        int max = 0;
        for (int i = 1; i < n; ++i) {

            if (word.charAt(i - 1) == word.charAt(i)) {
                ++len;
            } else if (word.charAt(i - 1) < word.charAt(i)) {
                ++len;
                ++cnt;
            } else {
                len = 1;
                cnt = 1;
            }
            if (cnt == 5) {
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int longestBeautifulSubstring_1(String word) {

        int n = word.length();
        int[] freq = new int[n];
        char[] arr = new char[n];
        int count = 0;
        int point = 0;
        int idx = 0;
        for (int i = 0; i <= n; ++i) {

            if (i < word.length() && word.charAt(point) == word.charAt(i)) {
                ++count;
            } else {
                freq[idx] = count;
                arr[idx] = word.charAt(point);
                ++idx;
                point = i;
                if (i == word.length()) {
                    break;
                }
                --i;
                count = 0;
            }
        }

        int sum = 0;
        int max = 0;
        for (int i = 4; i < idx; ++i) {
            if (arr[i] == 'u' && arr[i - 1] == 'o' && arr[i - 2] == 'i' && arr[i - 3] == 'e' && arr[i - 4] == 'a') {
                sum = freq[i] + freq[i - 1] + freq[i - 2] + freq[i - 3] + freq[i - 4];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
