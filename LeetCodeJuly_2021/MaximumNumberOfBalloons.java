import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {

        int[] cnt = new int[26];

        for (char ch : text.toCharArray()) {
            cnt[ch - 'a']++;
        }

        int min = cnt[0];
        min = Math.min(min, cnt[1]);
        min = Math.min(min, cnt[11] / 2);
        min = Math.min(min, cnt[14] / 2);
        min = Math.min(min, cnt[13]);

        return min;
    }

    public int maxNumberOfBalloons_1(String text) {

        int[] cnt = new int[26];
        Set<Character> set = new HashSet<>();

        for (char ch : text.toCharArray()) {
            cnt[ch - 'a']++;
        }

        int min = Integer.MAX_VALUE;
        for (char ch : text.toCharArray()) {

            if (ch == 'b' || ch == 'a' || ch == 'n') {
                min = Math.min(min, cnt[ch - 'a']);
                set.add(ch);
            } else if (ch == 'l' || ch == 'o') {
                min = Math.min(min, cnt[ch - 'a'] / 2);
                set.add(ch);
            }
        }

        for (char ch : "balon".toCharArray()) {
            if (!set.contains(ch)) {
                return 0;
            }
        }
        return min;
    }
}
