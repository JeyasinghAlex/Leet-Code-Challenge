import java.util.ArrayList;
import java.util.List;

public class KeyboardRow {

    public String[] findWords(String[] words) {

        int[] charLayer = new int[]{1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 2, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2};
        List<String> list = new ArrayList<>();
        for (String word : words) {
            list.add(word);
            String lowerCase = word.toLowerCase();
            char ch = lowerCase.charAt(0);

            int curr = charLayer[ch - 'a'];

            for (int i = 1; i < lowerCase.length(); ++i) {

                if (charLayer[lowerCase.charAt(i) - 'a'] != curr) {
                    list.remove(word);
                    break;
                }
            }
        }

        String[] ans = new String[list.size()];
        int idx = 0;
        for (String s : list) {
            ans[idx++] = s;
        }
        return ans;
    }

    public String[] findWords_1(String[] words) {

        String[] keyboard = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> list = new ArrayList<>();
        for (String word : words) {
            for (String row : keyboard) {
                int idx = 0;
                int n = word.length();
                String lower  = word.toLowerCase();
                while (idx < n && row.contains(lower.charAt(idx) + "")) {
                    ++idx;
                }
                if (idx == word.length()) {
                    list.add(word);
                    break;
                }
            }
        }

        String[] res = new String[list.size()];
        int idx = 0;
        for (String s : list) {
            res[idx++] = s;
        }
        return res;
    }
}
