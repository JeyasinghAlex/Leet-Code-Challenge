import java.util.ArrayList;
import java.util.List;

public class SubStringsOfSizeThreeWithDistinctCharacters {

    public int countGoodSubstrings(String s) {

        int l = 0;
        int count = 0;
        for (int r = 2; r < s.length(); ++r, ++l) {
            if (isGood(l, r, s)) {
                ++count;
            }
        }
        return count;
    }

    private boolean isGood(int l, int r, String s) {

        List<Character> list = new ArrayList<>();
        for (int i = l; i <= r; ++i) {

            if (list.contains(s.charAt(i))) {
                return false;
            }
            list.add(s.charAt(i));
        }
        return true;
    }
}
