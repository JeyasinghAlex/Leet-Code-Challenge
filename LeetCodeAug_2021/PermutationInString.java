import java.util.Arrays;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        if (n > m) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char ch : s1.toCharArray()) {
            freq1[ch - 'a']++;
        }

        for (int i = 0; i < n; ++i) {
            char ch = s2.charAt(i);
            freq2[ch - 'a']++;
        }


        for (int i = n; i <= m; ++i) {
            if (isTrue(freq1, freq2)) {
                return true;
            }

            if (i == m) {
                return false;
            }

            freq2[s2.charAt(i) - 'a']++;
            freq2[s2.charAt(i - n) - 'a']--;
        }
        return false;
    }

    private boolean isTrue(int[] freq1, int[] freq2) {

        for (int i = 0; i < 26; ++i) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion_2(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;
        String base = s1.length() > s2.length() ? s2 : s1;
        String compare = s1.length() > s2.length() ? s1 : s2;
        int[] b = new int[26];
        int[] c = new int[26];
        for (int i = 0; i < base.length(); ++i) {
            b[base.charAt(i) - 'a']++;
        }

        for (int i = 0; i < base.length() - 1; ++i) {
            c[compare.charAt(i) - 'a']++;
        }

        int start = 0;
        for (int i = base.length() - 1; i < compare.length(); ++i) {
            c[compare.charAt(i) - 'a']++;
            if (isPermudation(b, c)) {
                return true;
            }
            c[compare.charAt(start++) - 'a']--;
        }
        return false;
    }

    private boolean isPermudation(int[] a, int[] b) {

        for (int i = 0; i < 26; ++i) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion_1(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;

        String base = s1.length() > s2.length() ? s2 : s1;
        String compare = s1.length() > s2.length() ? s1 : s2;
        int[] count = new int[26];

        for (char ch : base.toCharArray()) {
            count[ch - 'a']++;
        }

        for (int i = 0; i <= compare.length() - base.length(); ++i) {
            int[] temp = Arrays.copyOf(count, 26);
            boolean res = check(compare, i, base.length() - 1+ i, temp);
            if (res) {
                return true;
            }
        }
        return false;
    }

    private boolean check(String s, int start, int end, int[] temp) {

        for (int i = start; i <= end; ++i) {
            char ch = s.charAt(i);
            temp[ch - 'a']--;
        }

        for (int n : temp) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
}
