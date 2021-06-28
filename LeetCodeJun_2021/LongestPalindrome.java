import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {

    public int longestPalindrome(String s) {

        int[] cnt = new int[128];
        for (char ch : s.toCharArray()) {
            cnt[ch]++;
        }
        int odd = 0;
        for (int n : cnt) {
            odd += (n & 1);
        }
        return s.length() - odd + (odd > 0 ? 1 : 0);
    }


    public int longestPalindrome_1(String s) {

        Set<Character> set = new HashSet<>();
        int count = 0;
        for (char ch : s.toCharArray()) {

            if (set.contains(ch)) {
                ++count;
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        return set.isEmpty() ? count * 2 : (count * 2) + 1;
    }

    public int longestPalindrome_2(String s) {

        Map<Character, Integer> map = new HashMap<>();
        boolean flag = false;
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }

        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            if ((entry.getValue() & 1) == 0) {
                count += entry.getValue();
            }
            else if ((entry.getValue() & 1) == 1) {
                count += entry.getValue() - 1;
                flag = true;
            }
        }
        if (flag) {
            count++;
        }
        return count;
    }
}
