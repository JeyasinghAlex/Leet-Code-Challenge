import java.util.*;

public class FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {

        int window = p.length();
        int len = s.length();
        List<Integer> ans = new ArrayList<>();
        if (window > len) {
            return ans;
        }

        int[] base = new int[26];
        int[] compare = new int[26];
        int right = 0;
        int left = 0;
        for (int i = 0; i < p.length(); ++i) {
            base[p.charAt(right) - 'a']++;
            compare[s.charAt(right++) - 'a']++;
        }

        for (int i = right; i <= len; ++i) {
            if (check(base, compare)){
                ans.add(left);
            }
            if (i < len) {
                compare[s.charAt(left++) - 'a']--;
                compare[s.charAt(i) - 'a']++;
            }
        }
        return ans;
    }

    private boolean check(int[] base, int[] compare) {

        for (int i = 0; i < base.length; ++i) {
            if (base[i] != compare[i]) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams_1(String s, String p) {

        String base = sort(p);
        int n = p.length();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= s.length() - n; ++i) {
            String temp = sort(s.substring(i, i + n));
            if (base.equals(temp)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private String sort(String s) {

        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (int i = 0; i < 26; ++i) {
            while (freq[i]-- > 0) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}
