package weekly_03;

public class MinimumMovesToConvertString {

    public int minimumMoves(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); ++i) {

            if (chars[i] == 'X') {
                ++count;
                i = i + 2;
            }
        }
        return count;
    }

    public int minimumMoves_1(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); ++i) {

            if (chars[i] == 'X') {
                ++count;
                for (int j = i; j < i + 3 && j < s.length(); ++j) {
                    chars[j] = 'O';
                }
            }
        }
        return count;
    }
}
