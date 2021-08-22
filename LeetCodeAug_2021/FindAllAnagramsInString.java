import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInString {

    public static void main(String[] args) {
        System.out.println(new FindAllAnagramsInString().findAnagrams("cbaebabacd", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

        int[] hash = new int[26];

        for (char c : p.toCharArray()) {
            hash[c - 'a']++;
        }

        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {

            if (hash[s.charAt(right) - 'a'] >= 1) {
                count--;
            }
            hash[s.charAt(right) - 'a']--;
            right++;

            if (count == 0) {
                list.add(left);
            }
            if (right - left == p.length() ) {

                if (hash[s.charAt(left) - 'a'] >= 0) {
                    count++;
                }
                hash[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return list;
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
