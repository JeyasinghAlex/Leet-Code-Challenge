import java.util.Arrays;

public class FindWordsThatCanBeFormedByCharacters {

    public int countCharacters(String[] words, String chars) {

        int[] cnt = new int[26];

        for(char ch : chars.toCharArray()) {
            cnt[ch - 'a']++;
        }

        int len = 0;
        for (String word : words) {
            boolean flag = true;
            int[] temp = Arrays.copyOf(cnt, cnt.length);
            for (char ch : word.toCharArray()) {
                temp[ch - 'a']--;
                if (temp[ch - 'a'] < 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                len += word.length();
            }
        }
        return len;
    }


    public int countCharacters_1(String[] words, String chars) {

        int[] cnt = new int[26];

        for(char ch : chars.toCharArray()) {
            cnt[ch - 'a']++;
        }

        int len = 0;
        for (String word : words) {
            boolean flag = true;
            for (char ch : word.toCharArray()) {
                cnt[ch - 'a']--;
                if (cnt[ch - 'a'] < 0) {
                    flag = false;
                }
            }
            if (flag) {
                len += word.length();
            }

            for (char ch : word.toCharArray()) {
                cnt[ch - 'a']++;
            }
        }
        return len;
    }
}
